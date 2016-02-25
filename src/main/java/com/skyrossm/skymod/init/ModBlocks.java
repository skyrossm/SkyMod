package com.skyrossm.skymod.init;

import com.skyrossm.skymod.block.BlockSkyMod;
import com.skyrossm.skymod.block.BlockTest;
import com.skyrossm.skymod.item.ItemSkyMod;
import com.skyrossm.skymod.item.ItemTest;
import com.skyrossm.skymod.reference.Reference;
import com.skyrossm.skymod.util.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Skyrossm on 2/24/2016.
 */
public class ModBlocks {
    public static final BlockSkyMod testBlock = new BlockTest();

    public static void init() {
        GameRegistry.registerBlock(testBlock);
        LogHelper.info("Loaded Blocks");
    }

    public static void renderInit(Side side){
        if(side == Side.CLIENT){
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(testBlock), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockTest) testBlock).getUnlocalizedName().substring(5), "inventory"));
        }
    }
}
