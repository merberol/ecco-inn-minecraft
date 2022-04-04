package com.transaticka.eccoinn.util;

import com.transaticka.eccoinn.EccoInnMod;
import com.transaticka.eccoinn.item.ModItems;

import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {


		
	public static void registerModStuffs() {
		registerFuels();
	}
		
	private static void registerFuels() {
		EccoInnMod.LOGGER.info("Registering Fuels for " + EccoInnMod.MOD_ID);
		FuelRegistry registry = FuelRegistry.INSTANCE;
		
		// 400 / 20 = 20 seconds => 1/4 of a coal
		
		registry.add(ModItems.DOWSING_ROD, 400);
	}
	
}
