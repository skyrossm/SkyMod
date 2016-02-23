package com.skyrossm.skymod.handler;

import com.google.common.eventbus.Subscribe;
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
    public static boolean recipeDefault = true;

    public static void init(File configFile){
        if(config == null){
            config = new Configuration(configFile);
            loadConfig();
        }
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
        if(event.modID.equalsIgnoreCase(Reference.MOD_ID)){
            loadConfig();
        }
    }

    private static void loadConfig(){
        recipeDefault = config.get(Configuration.CATEGORY_GENERAL, "recipeDefault", true, "Basic Recipe Enable/Disable [Default: true]").getBoolean(true);
        if(config.hasChanged())
            config.save();
    }
}
