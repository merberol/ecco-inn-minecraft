package com.transaticka.eccoinn;

import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transaticka.eccoinn.block.ModBlocks;
import com.transaticka.eccoinn.custom.GateSystem;
import com.transaticka.eccoinn.enchantment.ModEnchantments;
import com.transaticka.eccoinn.item.ModItems;
import com.transaticka.eccoinn.mixin.SessionAccessor;
import com.transaticka.eccoinn.util.ModRegistries;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.level.storage.LevelStorage;
// ToDo : Fix drop tables for custom blocks. */


public class EccoInnMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "eccoinnmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Path worldFolderPath;

	private static final GateSystem gateSystem = new GateSystem();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		
		ServerLifecycleEvents.SERVER_STARTING.register((server) -> {
            LevelStorage.Session session = ((SessionAccessor)server).getSession();
            String worldName = session.getDirectoryName();
            EccoInnMod.LOGGER.info(worldName);
            if (!server.isDedicated()) { //here we check if the server IS NOT dedicated, if it isn't we use the integrated server's file path
            	worldFolderPath =  Path.of("saves", worldName);
            } else { // if the server IS dedicated, we use the dedicated server's file path
            	worldFolderPath =  Path.of(worldName);
            }  
            // EccoInnMod.LOGGER.info("ROOTGAMEPATH: " + EccoInnMod.worldFolderPath);
        });
	
		EccoInnMod.LOGGER.info("Initializing Ecco Inn!");
		
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        
        ModEnchantments.registerModEnchantments();
        
        ModRegistries.registerModStuffs();
        
        gateSystem.onInitialize();
        
       
	}
	
	
	
	public static void registerPortal(BlockPos pos, int state) {
		
		gateSystem.register(pos, state);
		
	}
	
	public static void unregisterPortal(BlockPos pos) {
		
		gateSystem.unregister(pos);
		
	}
	
	public static GateSystem getGateSystem() {
		return gateSystem;
	}
	
	public static void loadGateSystem() {
		gateSystem.load();
	}
	
}
