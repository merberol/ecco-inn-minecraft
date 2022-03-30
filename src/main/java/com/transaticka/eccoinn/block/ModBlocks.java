package com.transaticka.eccoinn.block;

import com.transaticka.eccoinn.EccoInnMod;
import com.transaticka.eccoinn.item.ModItemGroups;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks
{
	// ************* Harvested Blocks
	public static Block MITHRIL_ORE = registerBlock("mithril_ore", new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(5.0f, 6.0f)), ModItemGroups.ECCO_INN);
	public static Block DEEPSLATE_MITHRIL_ORE = registerBlock("deepslate_mithril_ore", new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(5.0f, 6.0f)), ModItemGroups.ECCO_INN);
	
	// ************* Raw Blocks // first tier crafting 
	public static Block RAW_MITHRIL_BLOCK = registerBlock("raw_mithril_block", new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.5f, 6.0f)), ModItemGroups.ECCO_INN);
    
	// ************** Base Blocks // second tier crafting
	public static Block MITHRIL_BLOCK = registerBlock("mithril_block", new Block(FabricBlockSettings.of(Material.METAL).requiresTool().strength(120.0f, 1500.0f)), ModItemGroups.ECCO_INN);
 

    
    private static Block registerBlock(final String name, final Block block, final ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier("eccoinnmod", name), block);
    }
    
    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier("eccoinnmod", name),
        		new BlockItem(block, new FabricItemSettings().group(group)));
    }
    
    public static void registerModBlocks() {
        EccoInnMod.LOGGER.info("Registring Mod Blocks");
    }
    

}