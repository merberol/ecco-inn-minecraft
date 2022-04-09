package com.transaticka.eccoinn.block.custom;

import com.transaticka.eccoinn.EccoInnMod;
import com.transaticka.eccoinn.custom.GateSystem;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.explosion.Explosion;

public class GatewayBlock extends Block {
	

	public GatewayBlock(Settings settings) {
		super(settings);
	
	}

	@Override
	public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {

		if(!world.isClient()) {			
			unregister(pos);
		}
		super.onBroken(world, pos, state);
	}

	@Override
	public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {

		if(!world.isClient()) {			
			unregister(pos);
		}
		super.onDestroyedByExplosion(world, pos, explosion);
	}

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {

		if(!world.isClient()) {			
			register(pos,1);
		}
		super.onPlaced(world, pos, state, placer, itemStack);
	}

	@Override
	public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
		/* TODO: implement energy */
		/* TODO: implement some way to target specific coordinates */
		
		if(!world.isClient()) {
			
			GateSystem gs = EccoInnMod.getGateSystem();
			if (gs.isActive(pos))
			{
				
				BlockPos telePos = gs.getRandomPos(pos);
				EccoInnMod.LOGGER.info("teleporting to: " + telePos);
				entity.teleport(telePos.getX() + 1, telePos.getY() + 1, telePos.getZ());
			}
		}
		super.onSteppedOn(world, pos, state, entity);
	}
	
	private void register(BlockPos pos, int state) {
		EccoInnMod.LOGGER.debug("regisering portal with portal system");
		EccoInnMod.registerPortal(pos, state);
	}
	
	private void unregister(BlockPos pos) {
		EccoInnMod.LOGGER.debug("regisering portal with portal system");
		EccoInnMod.unregisterPortal(pos);
	}
	
	
	

}
