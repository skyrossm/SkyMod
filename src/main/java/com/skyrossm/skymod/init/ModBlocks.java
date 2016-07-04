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
    public static final BlockSkyMod oreCobalt = new BlockSkyMod("oreCobalt");
    public static final BlockSkyMod oreSilver = new BlockSkyMod("oreSilver");
    public static final BlockSkyMod oreCopper = new BlockSkyMod("oreCopper");
    public static final BlockSkyMod oreTitanium = new BlockSkyMod("oreTitanium");


    public static void init() {
        oreCobalt.setHardness(5);
        oreSilver.setHardness(5);
        oreCopper.setHardness(5);
        oreTitanium.setHardness(5);
        GameRegistry.registerBlock(testBlock);
        GameRegistry.registerBlock(oreCobalt);
        GameRegistry.registerBlock(oreSilver);
        GameRegistry.registerBlock(oreCopper);
        GameRegistry.registerBlock(oreTitanium);
        LogHelper.info("Loaded Blocks");
    }

    public static void renderInit(Side side){
        if(side == Side.CLIENT){
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(testBlock), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockSkyMod) testBlock).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(oreCobalt), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockSkyMod) oreCobalt).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(oreCopper), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockSkyMod) oreCopper).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(oreSilver), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockSkyMod) oreSilver).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(oreTitanium), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockSkyMod) oreTitanium).getUnlocalizedName().substring(5), "inventory"));
        }
    }
}
