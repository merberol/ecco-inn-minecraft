package com.transaticka.eccoinn.item.custom;

import com.transaticka.eccoinn.util.ModTags;

import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;

public class ModPaxelItem extends MiningToolItem{

	public ModPaxelItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
		super(attackDamage, attackSpeed, material, ModTags.Blocks.PAXEL_MINEABLE, settings);
	}

	
}
