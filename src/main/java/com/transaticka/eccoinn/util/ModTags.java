package com.transaticka.eccoinn.util;

import com.transaticka.eccoinn.EccoInnMod;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ModTags {
	public static class Blocks{
		
		public static final Tag.Identified<Block> DOWSING_ROD_DETECTABLE_BLOCKS = 
				createTag("dowsing_rod_detectable_blocks");
		
		public static final Tag.Identified<Block> MITHRIL_BLOCKS = 
				createCommonTag("mithril_blocks");
		
		public static final Tag.Identified<Block> MITHRIL_ORES = 
				createCommonTag("mithril_ores");
		
		private static Tag.Identified<Block> createTag(String name) {
			return TagFactory.BLOCK.create(new Identifier(EccoInnMod.MOD_ID, name));
		}
		
		private static Tag.Identified<Block> createCommonTag(String name) {
			return TagFactory.BLOCK.create(new Identifier("c", name));
		}
	}

	public static class Items{
		
		public static final Tag.Identified<Item> MITHRIL_INGOTS = 
				createCommonTag("mithril_ingots");
		
		public static final Tag.Identified<Item> MITHRIL_NUGGETS = 
				createCommonTag("mithril_nuggets");
		
		private static Tag.Identified<Item> createTag(String name) {
			return TagFactory.ITEM.create(new Identifier(EccoInnMod.MOD_ID, name));
		}
		
		private static Tag.Identified<Item> createCommonTag(String name) {
			return TagFactory.ITEM.create(new Identifier("c", name));
		}
		
	}
}