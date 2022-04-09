package com.transaticka.eccoinn.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroups
{
    public static final ItemGroup  ECCO_INN = FabricItemGroupBuilder.build(new Identifier("eccoinnmod", "ecco_inn"), () -> new ItemStack(ModItems.MITHRIL_INGOT));
    
}