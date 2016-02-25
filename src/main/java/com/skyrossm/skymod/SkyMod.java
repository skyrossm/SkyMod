package com.skyrossm.skymod;

import com.skyrossm.skymod.handler.ConfigHandler;
import com.skyrossm.skymod.init.ModBlocks;
import com.skyrossm.skymod.init.ModItems;
import com.skyrossm.skymod.item.ItemTest;
import com.skyrossm.skymod.network.PacketHandler;
import com.skyrossm.skymod.proxy.IProxy;
import com.skyrossm.skymod.reference.Reference;
import com.skyrossm.skymod.util.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERISON, guiFactory = Reference.GUI_FACTORY_CLASS)
public class SkyMod{

    @Mod.Instance(Reference.MOD_ID)
    public static SkyMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ConfigHandler.init(event.getSuggestedConfigurationFile());

        MinecraftForge.EVENT_BUS.register(new ConfigHandler());

        ModItems.init();
        ModBlocks.init();
        PacketHandler.init();

        LogHelper.info("Pre Init Complete.");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        ModItems.renderInit(event.getSide());
        ModBlocks.renderInit(event.getSide());
        LogHelper.info("Init Complete.");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        LogHelper.info("Post Init Complete.");
    }
}
