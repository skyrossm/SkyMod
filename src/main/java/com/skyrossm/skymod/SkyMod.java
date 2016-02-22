package com.skyrossm.skymod;

import com.skyrossm.skymod.proxy.IProxy;
import com.skyrossm.skymod.reference.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERISON)
public class SkyMod{

    @Mod.Instance(Reference.MOD_ID)
    public static SkyMod instance;

    @SidedProxy(clientSide = "com.skyrossm.skymod.proxy.ClientProxy", serverSide = "com.skyrossm.skymod.proxy.ServerProxy")
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}
