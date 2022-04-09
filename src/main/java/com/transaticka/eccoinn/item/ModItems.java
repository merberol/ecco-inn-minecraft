package com.transaticka.eccoinn.item;

import com.transaticka.eccoinn.EccoInnMod;
import com.transaticka.eccoinn.item.custom.DowsingRodItem;
import com.transaticka.eccoinn.item.custom.MithrilAxeItem;
import com.transaticka.eccoinn.item.custom.MithrilPickaxeItem;
import com.transaticka.eccoinn.item.custom.ModArmorItem;
import com.transaticka.eccoinn.item.custom.ModHoeItem;
import com.transaticka.eccoinn.item.custom.ModPaxelItem;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems
{
	
    // ************* Harvested Materials
	public static final Item TURNIP = registerItem("turnip", new Item(new FabricItemSettings().group(ModItemGroups.ECCO_INN).food(ModFoodComponents.TURNIP)));
	
	// ************* Raw materials // first tier crafting 
	public static final Item RAW_MITHRIL = registerItem("raw_mithril", new Item(new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
	
	
	
	// ************** Base Crafting mats // second tier crafting
	public static final Item MITHRIL_INGOT = registerItem("mithril_ingot", new Item(new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
	public static final Item MITHRIL_NUGGET = registerItem("mithril_nugget", new Item(new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
	
	
	// ************** Custom Items
	
	public static final Item DOWSING_ROD = registerItem("dowsing_rod", 
			new DowsingRodItem(new FabricItemSettings().group(ModItemGroups.ECCO_INN).maxDamage(64)));
	
	
	// *************** Custom Tools
	
	public static final Item MITHRIL_PICKAXE = registerItem("mithril_pickaxe", 
			new MithrilPickaxeItem(ModToolMaterial.MITHRIL, 2, 2f,
					new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
	
	public static final Item MITHRIL_AXE = registerItem("mithril_axe", 
			new MithrilAxeItem(ModToolMaterial.MITHRIL, 5, 2f,
					new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
	
	public static final Item MITHRIL_HOE = registerItem("mithril_hoe", 
			new ModHoeItem(ModToolMaterial.MITHRIL, 0, 0f,
					new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
	
	public static final Item MITHRIL_SHOVEL = registerItem("mithril_shovel", 
			new ShovelItem(ModToolMaterial.MITHRIL, 0, 0f,
					new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
	
	public static final Item MITHRIL_SWORD = registerItem("mithril_sword", 
			new SwordItem(ModToolMaterial.MITHRIL, 4, 3f,
					new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
	
	public static final Item MITHRIL_PAXEL = registerItem("mithril_paxel", 
			new ModPaxelItem(ModToolMaterial.MITHRIL, 1, 1f,
					new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
	
	// ************* Custom Armor
	
	public static final Item MITHRIL_CHAIN_COIF = registerItem("mithril_chain_coif", 
			new ModArmorItem(ModArmorMaterials.MITHRIL_CHAINMAIL, EquipmentSlot.HEAD,
					new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
	
	public static final Item MITHRIL_CHAIN_SHIRT = registerItem("mithril_chain_shirt", 
			new ModArmorItem(ModArmorMaterials.MITHRIL_CHAINMAIL, EquipmentSlot.CHEST,
					new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
	
	public static final Item MITHRIL_CHAIN_LEGGINGS = registerItem("mithril_chain_leggings", 
			new ModArmorItem(ModArmorMaterials.MITHRIL_CHAINMAIL, EquipmentSlot.LEGS,
					new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
	
	public static final Item MITHRIL_CHAIN_BOOTS = registerItem("mithril_chain_boots", 
			new ModArmorItem(ModArmorMaterials.MITHRIL_CHAINMAIL, EquipmentSlot.FEET,
					new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
	
	public static final Item MITHRIL_HELMET = registerItem("mithril_helmet", 
			new ArmorItem(ModArmorMaterials.MITHRIL, EquipmentSlot.HEAD,
					new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
	
	public static final Item MITHRIL_CHESTPLATE = registerItem("mithril_chestplate", 
			new ModArmorItem(ModArmorMaterials.MITHRIL, EquipmentSlot.CHEST,
					new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
	
	public static final Item MITHRIL_LEGGINGS = registerItem("mithril_leggings", 
			new ModArmorItem(ModArmorMaterials.MITHRIL, EquipmentSlot.LEGS,
					new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
	
	public static final Item MITHRIL_BOOTS = registerItem("mithril_boots", 
			new ModArmorItem(ModArmorMaterials.MITHRIL, EquipmentSlot.FEET,
					new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
	
	public static final Item MITHRIL_HORSE_ARMOR = registerItem("mithril_horse_armor", 
			new HorseArmorItem(15, "mithril",
					new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
	
	
    
    private static Item registerItem(final String name, final Item item) {
        return Registry.register(Registry.ITEM, new Identifier("eccoinnmod", name), item);
    }
    
    public static void registerModItems() {
        EccoInnMod.LOGGER.info("Registring Mod Items");
    }
    
}