package com.transaticka.eccoinn.custom;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.transaticka.eccoinn.EccoInnMod;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
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
		
		ServerLifecycleEvents.SERVER_STOPPING.register(new GSServerStopping(this));
		ServerLifecycleEvents.SERVER_STOPPED.register(new GSServerStopped(this));
		
	}
	
	
	public void generateSaveState() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		data = gson.toJson(this.gates);
		
		EccoInnMod.LOGGER.info("GateSystem generated the following data" + data);
		

		
	}
	
	public void save() {
		// source https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it
		try{
            // Create new file
			//String dir = ;
            String path = "portalsystem.json";
            File file = new File(path);

            // If file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            // Write in file
            bw.write(this.data);

            // Close connection
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
	}
	
	public void register(BlockPos pos, int state) {
		EccoInnMod.LOGGER.info("registering gate at pos: " + pos);
		gates.put(pos, state);
	}
	
	public void unregister(BlockPos pos) {
		EccoInnMod.LOGGER.info("unregistering gate at pos: " + pos);
		gates.remove(pos);
	}
	
	
	public BlockPos getRandomPos(BlockPos current) {
		ArrayList<BlockPos> keysAsArray = new ArrayList<BlockPos>(this.gates.keySet());
		BlockPos next = current;;
		Random r = new Random();
		keysAsArray.remove(current);
		int size = keysAsArray.size();
		
		EccoInnMod.LOGGER.info("Gate System: " + gates);
		if(size < 1) {
			EccoInnMod.LOGGER.warn("Gate System has no logged gates!");
			return next;
		}
		else if(size >= 2) {
			
			next =  keysAsArray.remove( r.nextInt( size ) );
			while (this.equals(current, next))
			{	
				size = keysAsArray.size();
				if(size < 1) {
					EccoInnMod.LOGGER.warn("Gate System has no logged gates!");
				}
				next =  keysAsArray.remove( r.nextInt( size ) );
			}
			EccoInnMod.LOGGER.info("returning pos: " + next);

		}
		else if(size == 1) {
			next = keysAsArray.get(0);
			EccoInnMod.LOGGER.info("returning: " + next);
		}
		return next;
	}
	
	private boolean equals(BlockPos current, BlockPos other) {
		return current.getX() == other.getX() && current.getY() == other.getY() && current.getZ() == other.getZ();
	}
	
}
