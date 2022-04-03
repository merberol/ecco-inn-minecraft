package com.transaticka.eccoinn.custom;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.transaticka.eccoinn.EccoInnMod;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.util.math.BlockPos;


public class GateSystem {
	
	private HashMap<BlockPos, Integer> gates;

	public GateSystem() {	
		gates = new HashMap<BlockPos, Integer>();
	}
	
	public GateSystem get() {
		return this;
	}
	
	public void onInitialize() {
		EccoInnMod.LOGGER.info("Initializing GateSystem");
		ServerLifecycleEvents.SERVER_STARTING.register((server) -> {
            
            EccoInnMod.LOGGER.info("GS on server startingsave folder path is: " + EccoInnMod.worldFolderPath.toString());
            EccoInnMod.loadGateSystem();
        });
		ServerLifecycleEvents.SERVER_STOPPED.register(new GSServerStopped(this));
	}
	
	public void load() {
		try 
		{
			String path = EccoInnMod.worldFolderPath.toString() + "/portalsystem.json";
		    File file = new File(path);
		    Gson gson = new Gson();
		    
		    
		    if (!file.exists()) {
                file.createNewFile();
                EccoInnMod.LOGGER.info("Created File as it did not exist.");
                return;
            }
		    
		    String jsonString = Files.readString(Path.of(path));
		    JsonObject data = gson.fromJson(jsonString, JsonObject.class);
		    EccoInnMod.LOGGER.info("Loaded Data from file: " + data);
		    
		    ArrayList<String> keysAsArray = new ArrayList<>(data.keySet());
		    
		    for (int i = 0; i < keysAsArray.size(); i++) {
		    	EccoInnMod.LOGGER.info("Key: " + keysAsArray.get(i) + " Value: " + data.get(keysAsArray.get(i)));
		    	try {
		    		// EccoInnMod.LOGGER.info("trying to parse key");
		    		JsonObject key = gson.fromJson(keysAsArray.get(i).replaceAll("(\")", ""), JsonObject.class);
		    		// EccoInnMod.LOGGER.info("trying to konvert key to pos");
		    		BlockPos pos = new BlockPos(key.get("x").getAsInt(), key.get("y").getAsInt(), key.get("z").getAsInt());
		    		// EccoInnMod.LOGGER.info("trying to get val and convert to int");
		    		int val = data.get(keysAsArray.get(i)).getAsInt();
		    		// EccoInnMod.LOGGER.info("trying to add pair to map");
		    		this.gates.put(pos, val);
		    		// EccoInnMod.LOGGER.info("Created block pos instance: " + pos + " adn added to gates: " + this.gates);
		    	}catch(Exception e) {
		    		System.out.println(e);
		    	}
		    }

		    
		    
		} catch (Exception e) {
			System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	public void save() {
		try {
			// source https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it
			String path = EccoInnMod.worldFolderPath.toString() + "/portalsystem.json";
	        File file = new File(path);

	        // If file doesn't exists, then create it
	        if (!file.exists()) {
	            file.createNewFile();
	        }

        	FileWriter fw = new FileWriter( file.getAbsoluteFile() );

            fw.write(this.toJson());

            fw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
	}
	
	public void register(BlockPos pos, int state) {
		//EccoInnMod.LOGGER.info("registering gate at pos: " + pos);
		gates.put(pos, state);
	}
	
	public void unregister(BlockPos pos) {
		//EccoInnMod.LOGGER.info("unregistering gate at pos: " + pos);
		gates.remove(pos);
	}
	
	public boolean isActive(BlockPos pos) {
		if (gates.get(pos) != null)
		{
			return gates.get(pos) == 1;
		}
		return false;
		
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
	
	public String toJson() {
		ArrayList<BlockPos> keysAsArray = new ArrayList<BlockPos>(this.gates.keySet());
		
		String asJson = "{";
		boolean first = true;
		for (BlockPos pos : keysAsArray)
		{
			String temp;
			if(first)
			{
				first = !first;
				temp = "\"{ x:" + pos.getX() + ", y:" + pos.getY() + ", z:" + pos.getZ() + "}\":" + this.gates.get(pos);
			}else {
				temp = ", \"{ x:" + pos.getX() + ", y:" + pos.getY() + ", z:" + pos.getZ() + "}\":" + this.gates.get(pos);
			}
			asJson += temp;
		}
		asJson += "}";
		return asJson;
	}
	
}
