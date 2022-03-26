package com.transaticka.eccoinn.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

public class ModItemGroups
{
    public static final ItemGroup  ECCO_INN = FabricItemGroupBuilder.build(new Identifier("eccoinnmod", "ecco_inn"), () -> new ItemStack(ModItems.MITHRIL_INGOT));
    
}