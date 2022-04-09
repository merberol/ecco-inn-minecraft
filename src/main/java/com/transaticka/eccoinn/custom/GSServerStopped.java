package com.transaticka.eccoinn.custom;

import com.transaticka.eccoinn.EccoInnMod;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.ServerStopped;
import net.minecraft.server.MinecraftServer;

public class GSServerStopped implements ServerStopped{
	
	private GateSystem _gs;
	public GSServerStopped(GateSystem gs) {

		super();
		
		this._gs = gs;
	}

	@Override
	public void onServerStopped(MinecraftServer server) {
		EccoInnMod.LOGGER.info("ServerStopped Saveing portalsystem data");
		this._gs.save();
		
	}
	
	
	

}
