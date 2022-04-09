package com.transaticka.eccoinn.item;

import java.util.function.Supplier;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

public enum ModToolMaterial implements ToolMaterial{

	APPLETREE(MiningLevels.WOOD, 59, 2.0F, 0.8F, 15, () ->
    Ingredient.ofItems(ModItems.TURNIP)),
	//ToDo: change to proper wood
	
	MITHRIL(MiningLevels.NETHERITE, 2041, 20.0F, 4.0F, 25, () ->
    Ingredient.ofItems(ModItems.MITHRIL_INGOT));

	private final int miningLevel;
	private final int itemDurability;
	private final float miningSpeed;
	private final float attackDamage;
	private final int enchantability;
	private final Lazy<Ingredient> repairIngredient;
	
	ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage,
	                    int enchantability, Supplier<Ingredient> repairIngredient) {
	this.miningLevel = miningLevel;
	this.itemDurability = itemDurability;
	this.miningSpeed = miningSpeed;
	this.attackDamage = attackDamage;
	this.enchantability = enchantability;
	this.repairIngredient = new Lazy(repairIngredient);
	}
	
	public int getDurability() {
	return this.itemDurability;
	}
	
	public float getMiningSpeedMultiplier() {
	return this.miningSpeed;
	}
	
	public float getAttackDamage() {
	return this.attackDamage;
	}
	
	public int getMiningLevel() {
	return this.miningLevel;
	}
	
	public int getEnchantability() {
	return this.enchantability;
	}
	
	public Ingredient getRepairIngredient() {
	return (Ingredient)this.repairIngredient.get();
}

}
