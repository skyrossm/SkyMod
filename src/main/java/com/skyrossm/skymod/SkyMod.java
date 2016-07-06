package com.skyrossm.skymod;

import com.skyrossm.skymod.client.gui.GuiHandler;
import com.skyrossm.skymod.events.EventManager;
import com.skyrossm.skymod.events.FMLCommonEventManager;
import com.skyrossm.skymod.generation.GeneratorManager;
import com.skyrossm.skymod.handler.ConfigHandler;
import com.skyrossm.skymod.handler.CraftingHandler;
import com.skyrossm.skymod.handler.FuelHandler;
import com.skyrossm.skymod.handler.SmeltingHandler;
import com.skyrossm.skymod.init.ModAchievements;
import com.skyrossm.skymod.init.ModBlocks;
import com.skyrossm.skymod.init.ModItems;
import com.skyrossm.skymod.item.ItemRingSuper;
import com.skyrossm.skymod.network.PacketHandler;
import com.skyrossm.skymod.proxy.ClientProxy;
import com.skyrossm.skymod.proxy.CommonProxy;
import com.skyrossm.skymod.proxy.IProxy;
import com.skyrossm.skymod.reference.Reference;
import com.skyrossm.skymod.util.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.UUID;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERISON, guiFactory = Reference.GUI_FACTORY_CLASS)
public class SkyMod{

    @Mod.Instance(Reference.MOD_ID)
    public static SkyMod instance;

    public static UUID globalID;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    public static ClientProxy cproxy;

    GeneratorManager genmanager = new GeneratorManager();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){

        SkyMod.globalID = UUID.fromString("f3efbbbb-b418-4c13-82d9-28590ca0db3b");
        ConfigHandler.init(event.getSuggestedConfigurationFile());

        MinecraftForge.EVENT_BUS.register(new ConfigHandler());

        ModItems.init();
        ModBlocks.init();
        ModAchievements.init();
        PacketHandler.init();
        CraftingHandler.loadRecipes();
        SmeltingHandler.loadRecipes();
        GameRegistry.registerWorldGenerator(genmanager, 0);
        GameRegistry.registerFuelHandler(new FuelHandler());

        MinecraftForge.EVENT_BUS.register(new EventManager());
        FMLCommonHandler.instance().bus().register(new FMLCommonEventManager());

        //Ore Dictionary
        OreDictionary.registerOre("ingotCopper", ModItems.itemCopperIngot);
        OreDictionary.registerOre("ingotSilver", ModItems.itemSilverIngot);
        OreDictionary.registerOre("ingotCobalt", ModItems.itemCobaltIngot);
        OreDictionary.registerOre("ingotTitanium", ModItems.itemTitaniumIngot);
        OreDictionary.registerOre("oreCopper", ModBlocks.oreCopper);
        OreDictionary.registerOre("oreSilver", ModBlocks.oreSilver);
        OreDictionary.registerOre("oreCobalt", ModBlocks.oreCobalt);
        OreDictionary.registerOre("oreTitanium", ModBlocks.oreTitanium);
        OreDictionary.registerOre("blockCopper", ModBlocks.blockCopper);
        OreDictionary.registerOre("blockSilver", ModBlocks.blockSilver);
        OreDictionary.registerOre("blockCobalt", ModBlocks.blockCobalt);
        OreDictionary.registerOre("blockTitanium", ModBlocks.blockTitanium);

        LogHelper.info("Pre Init Complete.");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        ModItems.renderInit(event.getSide());
        ModBlocks.renderInit(event.getSide());
        proxy.registerKeyBinds();
        NetworkRegistry.INSTANCE.registerGuiHandler(SkyMod.instance, new GuiHandler());
        LogHelper.info("Init Complete.");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        LogHelper.info("Post Init Complete.");
    }

    public static void setPlayerData(EntityPlayer player, boolean fly, boolean health, boolean food, boolean regen){
        ItemRingSuper.setAbilites(player, fly, health, food, regen);
    }
}
