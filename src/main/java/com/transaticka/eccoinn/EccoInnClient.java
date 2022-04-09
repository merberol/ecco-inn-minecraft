package com.transaticka.eccoinn;

import com.transaticka.eccoinn.block.ModBlocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class EccoInnClient implements ClientModInitializer {



	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.APPLE_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.APPLE_TRAP_DOOR, RenderLayer.getCutout());
	}

	

}
