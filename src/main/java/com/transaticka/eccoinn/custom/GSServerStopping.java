package com.transaticka.eccoinn.custom;

import com.transaticka.eccoinn.EccoInnMod;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.ServerStopping;
import net.minecraft.server.MinecraftServer;

public class GSServerStopping implements ServerStopping{
	
	private GateSystem _gs;
	public GSServerStopping(GateSystem gs) {
		// TODO Auto-generated constructor stub
		super();
		
		this._gs = gs;
	}

	@Override
	public void onServerStopping(MinecraftServer server) {
		// TODO Auto-generated method stub
		EccoInnMod.LOGGER.info("Server stopping, generating portalsystem save data");
		this._gs.generateSaveState();
	}
	
	

}
