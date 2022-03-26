package com.transaticka.eccoinn.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import com.transaticka.eccoinn.EccoInnMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.item.Item;

public class ModItems
{
    public static final Item MITHRIL_INGOT = registerItem("mithril_ingot", new Item(new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
    public static final Item MITHRIL_NUGGET = registerItem("mithril_nugget", new Item(new FabricItemSettings().group(ModItemGroups.ECCO_INN)));
    
    private static Item registerItem(final String name, final Item item) {
        return Registry.register(Registry.ITEM, new Identifier("eccoinnmod", name), item);
    }
    
    public static void registerModItems() {
        EccoInnMod.LOGGER.info("Registring Mod Items");
    }
    
}