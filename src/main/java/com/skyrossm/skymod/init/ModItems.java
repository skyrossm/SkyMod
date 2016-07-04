package com.skyrossm.skymod.init;

import com.skyrossm.skymod.item.*;
import com.skyrossm.skymod.reference.Reference;
import com.skyrossm.skymod.util.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Skyrossm on 2/23/2016.
 */
public class ModItems {

    public static final ItemSkyMod testItem = new ItemTest();
    public static final ItemSkyMod ringItem = new ItemRing();
    public static final ItemSkyMod gemItem = new ItemGem();
    public static final ItemSkyMod flyRingItem = new ItemRingFly();
    public static final ItemSkyMod aolItem = new ItemAoL();

    public static void init() {
        GameRegistry.registerItem(testItem);
        GameRegistry.registerItem(ringItem);
        GameRegistry.registerItem(gemItem);
        GameRegistry.registerItem(flyRingItem);
        GameRegistry.registerItem(aolItem);
        LogHelper.info("Loaded Items");
    }

    public static void renderInit(Side side){
        if(side == Side.CLIENT) {
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

            renderItem.getItemModelMesher().register(ModItems.testItem, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((ItemTest) ModItems.testItem).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.ringItem, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((ItemRing) ModItems.ringItem).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.gemItem, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((ItemGem) ModItems.gemItem).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.flyRingItem, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((ItemRingFly) ModItems.flyRingItem).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.aolItem, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((ItemAoL) ModItems.aolItem).getUnlocalizedName().substring(5), "inventory"));
        }
    }
}
