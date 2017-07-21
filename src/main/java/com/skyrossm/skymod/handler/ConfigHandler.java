package com.skyrossm.skymod.handler;

import com.skyrossm.skymod.reference.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

/**
 * Created by Skyrossm on 2/22/2016.
 */
public class ConfigHandler {

    public static Configuration config;
    public static boolean silverSpawn = true;
    public static boolean copperSpawn = true;
    public static boolean cobaltSpawn = true;
    public static boolean titaniumSpawn = true;


    public static void init(File configFile){
        if(config == null){
            config = new Configuration(configFile);
            loadConfig();
        }
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
        if(event.getModID().equalsIgnoreCase(Reference.MOD_ID)){
            loadConfig();
        }
    }

    private static void loadConfig(){
        silverSpawn = config.get(Configuration.CATEGORY_GENERAL, "silverSpawn", true, "Enable Silver Ore Generation [Default: true]").getBoolean(true);
        copperSpawn = config.get(Configuration.CATEGORY_GENERAL, "copperSpawn", true, "Enable Copper Ore Generation [Default: true]").getBoolean(true);
        cobaltSpawn = config.get(Configuration.CATEGORY_GENERAL, "cobaltSpawn", true, "Enable Cobalt Ore Generation [Default: true]").getBoolean(true);
        titaniumSpawn = config.get(Configuration.CATEGORY_GENERAL, "titaniumSpawn", true, "Enable Titanium Ore Generation [Default: true]").getBoolean(true);

        if(config.hasChanged())
            config.save();
    }
}
