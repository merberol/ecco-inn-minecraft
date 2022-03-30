package com.transaticka.eccoinn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transaticka.eccoinn.block.ModBlocks;
import com.transaticka.eccoinn.custom.GateSystem;
import com.transaticka.eccoinn.item.ModItems;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.math.BlockPos;

public class EccoInnMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "eccoinnmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	
	private static final GateSystem gateSystem = new GateSystem();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		EccoInnMod.LOGGER.info("Initializing Ecco Inn!");
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        
        gateSystem.onInitialize();
        
       
	}
	
	public static void registerPortal(BlockPos pos, int state) {
		
		gateSystem.register(pos, state);
		
	}
	
	public static void unregisterPortal(BlockPos pos) {
		
		gateSystem.unregister(pos);
		
	}
}
