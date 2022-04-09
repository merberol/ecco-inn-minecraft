package com.transaticka.eccoinn.block.custom;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MithrilTrapdoorBlock extends ModTrapdoorBlock{

	public MithrilTrapdoorBlock(Settings settings) {
		super(settings);
	}

	

	@Override
	public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
		world.setBlockState(pos, state.with(OPEN, true));


		super.onSteppedOn(world, pos, state, entity);
	}



	@Override
	public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
		
		if(state.get(OPEN))
		{
			if(world.getBlockState(pos.north(1)).getBlock().getClass() == this.getClass())
				world.setBlockState(pos.north(1), state.with(OPEN, true));
			
			if(world.getBlockState(pos.south(1)).getBlock().getClass() == this.getClass())
				world.setBlockState(pos.south(1), state.with(OPEN, true));
			
			if(world.getBlockState(pos.east(1)).getBlock().getClass() == this.getClass())
				world.setBlockState(pos.east(1), state.with(OPEN, true));
			
			if(world.getBlockState(pos.west(1)).getBlock().getClass() == this.getClass())
				world.setBlockState(pos.west(1), state.with(OPEN, true));
		}
		if(world.getTime() % 8 == 0)
			world.setBlockState(pos, state.with(OPEN, false));

		super.randomDisplayTick(state, world, pos, random);
	}



	
	
	

	

}
