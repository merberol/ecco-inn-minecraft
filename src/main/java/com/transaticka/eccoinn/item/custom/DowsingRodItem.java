package com.transaticka.eccoinn.item.custom;

import java.util.List;

import com.transaticka.eccoinn.block.ModBlocks;
import com.transaticka.eccoinn.util.ModTags;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DowsingRodItem extends Item {

	public DowsingRodItem(Settings settings) {
		super(settings);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		// TODO Auto-generated method stub
		if(context.getWorld().isClient())
		{
			BlockPos positionClicked = context.getBlockPos();
			PlayerEntity player = context.getPlayer();
			boolean foundBlock = false;
			World world = context.getWorld();
			
			for (int i = 0; i <= positionClicked.getY(); i++) {
				Block blockBelow = world.getBlockState(positionClicked.down(i)).getBlock();
				
				if(isValuableBlock(blockBelow)) {
					outputValuableCoordinates(positionClicked, player, i, blockBelow);
					foundBlock = true;
					break;
				}
			}
			
			if(!foundBlock) {
				player.sendMessage(new TranslatableText("item.eccoinnmod.dowsing_rod.no_valuables"), false);
			}
		} // end of client context
		
		context.getStack().damage(1, context.getPlayer(),
				(player) -> player.sendToolBreakStatus(player.getActiveHand()));
		return super.useOnBlock(context);
	}
	
	

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		if(Screen.hasShiftDown()) {
			tooltip.add(new TranslatableText("tooltip.item.eccoinnmod.dowsing_rod.shift"));
		}else {
			tooltip.add(new TranslatableText("tooltip.eccoinnmod"));
		}
		super.appendTooltip(stack, world, tooltip, context);
	}

	private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, int i, Block blockBelow) {
		player.sendMessage(new LiteralText("Found " + blockBelow.asItem().getName().getString() + " at " +
		  "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")" ), false);
	}
	
	private boolean isValuableBlock(Block block) {
		return ModTags.Blocks.DOWSING_ROD_DETECTABLE_BLOCKS.contains(block);
				/*
				 * block == Blocks.DIAMOND_ORE 
				|| block == Blocks.DEEPSLATE_DIAMOND_ORE
				|| block == ModBlocks.MITHRIL_ORE
			    || block == ModBlocks.DEEPSLATE_MITHRIL_ORE
				|| block == Blocks.GOLD_ORE
				|| block == Blocks.DEEPSLATE_GOLD_ORE
				|| block == Blocks.WATER
				|| block == Blocks.LAVA;
	*/
	}
	
	
}
