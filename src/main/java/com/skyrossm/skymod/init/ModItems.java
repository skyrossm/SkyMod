package com.skyrossm.skymod.init;

import com.skyrossm.skymod.item.ItemSkyMod;
import com.skyrossm.skymod.item.ItemTest;
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

    public static void init() {
        GameRegistry.registerItem(testItem);
        LogHelper.info("Loaded Items");
    }

    public static void renderInit(Side side){
        if(side == Side.CLIENT) {
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

            renderItem.getItemModelMesher().register(ModItems.testItem, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((ItemTest) ModItems.testItem).getUnlocalizedName().substring(5), "inventory"));
        }
    }
}
