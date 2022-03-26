package com.transaticka.eccoinn.block;

import com.transaticka.eccoinn.item.ModItemGroups;
import net.minecraft.block.AbstractBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import com.transaticka.eccoinn.EccoInnMod;
import net.minecraft.item.BlockItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Block;

public class ModBlocks
{
    public static Block MITHRIL_BLOCK = registerBlock("mithril_block", new Block(FabricBlockSettings.of(Material.METAL).requiresTool().strength(120.0f, 1500.0f)), ModItemGroups.ECCO_INN);
    public static Block RAW_MITHRIL_BLOCK = registerBlock("raw_mithril_block", new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.5f, 6.0f)), ModItemGroups.ECCO_INN);
    public static Block MITHRIL_ORE = registerBlock("mithril_ore", new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(5.0f, 6.0f)), ModItemGroups.ECCO_INN);
 

    
    private static Block registerBlock(final String name, final Block block, final ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier("eccoinnmod", name), block);
    }
    
    private static Item registerBlockItem(final String name, final Block block, final ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier("eccoinnmod", name), new BlockItem(block, (Item.Settings)new FabricItemSettings().group(group)));
    }
    
    public static void registerModBlocks() {
        EccoInnMod.LOGGER.info("Registring Mod Blocks");
    }
    

}