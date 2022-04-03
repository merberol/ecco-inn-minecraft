package com.transaticka.eccoinn.item;

import com.transaticka.eccoinn.EccoInnMod;
import com.transaticka.eccoinn.item.custom.DowsingRodItem;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
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
	
	
	
	
    
    private static Item registerItem(final String name, final Item item) {
        return Registry.register(Registry.ITEM, new Identifier("eccoinnmod", name), item);
    }
    
    public static void registerModItems() {
        EccoInnMod.LOGGER.info("Registring Mod Items");
    }
    
}