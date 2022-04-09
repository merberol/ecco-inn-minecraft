package com.transaticka.eccoinn.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class LightningStrikerEnchantment extends Enchantment {

	public LightningStrikerEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
		super(weight, type, slotTypes);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {
		if(!user.world.isClient()) {
			ServerWorld world = ((ServerWorld)user.world);
			PlayerEntity player = ((PlayerEntity)user);
			BlockPos targetPos = target.getBlockPos();
		
			switch(level){
				case 1:
				{
					EntityType.LIGHTNING_BOLT.spawn(world, null, null, player, targetPos,
							SpawnReason.TRIGGERED, true, true);
					break;
				}
				case 2:
				{	
					EntityType.LIGHTNING_BOLT.spawn(world, null, null, player, targetPos,
							SpawnReason.TRIGGERED, true, true);
					
					EntityType.LIGHTNING_BOLT.spawn(world, null, null, player, targetPos,
							SpawnReason.TRIGGERED, true, true);
					break;
				}
			}
		}
		
		super.onTargetDamaged(user, target, level);
	}

	
	
}
