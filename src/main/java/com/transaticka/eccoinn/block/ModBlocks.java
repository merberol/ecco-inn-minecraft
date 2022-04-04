package com.transaticka.eccoinn.block;

import com.transaticka.eccoinn.EccoInnMod;
import com.transaticka.eccoinn.block.custom.GatewayBlock;
import com.transaticka.eccoinn.block.custom.ModDoorBlock;
import com.transaticka.eccoinn.block.custom.ModStairsBlock;
import com.transaticka.eccoinn.item.ModItemGroups;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallBlock;
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
	
	
	// ************** Base craftables // third tier crafting 
	public static Block MITHRIL_STAIRS = registerBlock("mithril_stairs", 
			new ModStairsBlock(ModBlocks.MITHRIL_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL).requiresTool().strength(120.0f, 1500.0f)), ModItemGroups.ECCO_INN);
	
	public static Block MITHRIL_SLAB = registerBlock("mithril_slab", 
			new SlabBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(120.0f, 1500.0f)), ModItemGroups.ECCO_INN);
	
	public static Block MITHRIL_WALL = registerBlock("mithril_wall", 
			new WallBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(120.0f, 1500.0f)), ModItemGroups.ECCO_INN);
	
	public static Block MITHRIL_FENCE = registerBlock("mithril_fence", 
			new FenceBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(120.0f, 1500.0f)), ModItemGroups.ECCO_INN);
	
	public static Block MITHRIL_FENCE_GATE = registerBlock("mithril_fence_gate", 
			new FenceGateBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(120.0f, 1500.0f)), ModItemGroups.ECCO_INN);
	
	public static Block MITHRIL_DOOR = registerBlock("mithril_door", 
			new ModDoorBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(120.0f, 1500.0f)), ModItemGroups.ECCO_INN);
	
	
	
	// ************** Custom blocks
	public static Block GATEWAY_BLOCK = registerBlock("gateway_block", new GatewayBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(120.0f, 1500.0f)), ModItemGroups.ECCO_INN);

    
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