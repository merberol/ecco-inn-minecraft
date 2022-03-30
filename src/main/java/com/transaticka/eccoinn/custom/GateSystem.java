package com.transaticka.eccoinn.custom;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.transaticka.eccoinn.EccoInnMod;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.ServerStopped;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.ServerStopping;
import net.minecraft.util.math.BlockPos;


public class GateSystem {
	
	private HashMap<BlockPos, Integer> gates;
	private String data;

	
	
	public GateSystem() {
		
		gates = new HashMap<>();


	}
	

	
	public GateSystem get() {
		return this;
	}
	
	

	
	
	
	public void onInitialize() {
		EccoInnMod.LOGGER.info("Initializing GateSystem");
		
		ServerLifecycleEvents.SERVER_STOPPING.register(generateSaveState(this));
		ServerLifecycleEvents.SERVER_STOPPED.register(save(this));
		
	}
	
	
	protected ServerStopping generateSaveState(GateSystem self) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		data = gson.toJson(self.gates);
		
		return (ServerStopping)ServerLifecycleEvents.SERVER_STOPPING;
		
	}
	
	protected ServerStopped save(GateSystem self) {
		// source https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it
		try{
            // Create new file

            String path = "portalsystem.json";
            File file = new File(path);

            // If file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            // Write in file
            bw.write(self.data);

            // Close connection
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
		
		return (ServerStopped)ServerLifecycleEvents.SERVER_STOPPED;
	}
	
	public void register(BlockPos pos, int state) {
		gates.put(pos, state);
	}
	
	public void unregister(BlockPos pos) {
		gates.remove(pos);
	}
	
}
