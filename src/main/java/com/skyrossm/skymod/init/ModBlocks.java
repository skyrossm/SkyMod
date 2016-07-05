package com.skyrossm.skymod.init;

import com.skyrossm.skymod.block.BlockSkyMod;
import com.skyrossm.skymod.block.BlockTest;
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
    public static final BlockSkyMod blockCopper = new BlockSkyMod("blockCopper");
    public static final BlockSkyMod blockCobalt = new BlockSkyMod("blockCobalt");
    public static final BlockSkyMod blockSilver = new BlockSkyMod("blockSilver");
    public static final BlockSkyMod blockTitanium = new BlockSkyMod("blockTitanium");
    public static final BlockSkyMod blockMagic = new BlockSkyMod("blockMagic");
    public static final BlockSkyMod oreCobalt = new BlockSkyMod("oreCobalt");
    public static final BlockSkyMod oreSilver = new BlockSkyMod("oreSilver");
    public static final BlockSkyMod oreCopper = new BlockSkyMod("oreCopper");
    public static final BlockSkyMod oreTitanium = new BlockSkyMod("oreTitanium");
    public static final BlockSkyMod oreMagic = new BlockSkyMod("oreMagic");

    public static final BlockSkyMod blockBlockDiamond = new BlockSkyMod("blockBlockDiamond");
    public static final BlockSkyMod blockBlockBlockDiamond = new BlockSkyMod("blockBlockBlockDiamond");


    public static void init() {
        oreCobalt.setHardness(5);
        oreSilver.setHardness(5);
        oreCopper.setHardness(5);
        oreTitanium.setHardness(5);
        oreMagic.setHardness(1);
        blockCobalt.setHardness(5);
        blockCopper.setHardness(5);
        blockSilver.setHardness(5);
        blockMagic.setHardness(5);
        blockTitanium.setHardness(1);

        blockBlockBlockDiamond.setHardness(5);
        blockBlockDiamond.setHardness(5);


        GameRegistry.registerBlock(oreCobalt);
        GameRegistry.registerBlock(oreSilver);
        GameRegistry.registerBlock(oreCopper);
        GameRegistry.registerBlock(oreTitanium);
        GameRegistry.registerBlock(oreMagic);
        GameRegistry.registerBlock(blockCobalt);
        GameRegistry.registerBlock(blockSilver);
        GameRegistry.registerBlock(blockCopper);
        GameRegistry.registerBlock(blockTitanium);
        GameRegistry.registerBlock(blockMagic);

        GameRegistry.registerBlock(blockBlockBlockDiamond);
        GameRegistry.registerBlock(blockBlockDiamond);

        LogHelper.info("Loaded Blocks");
    }

    public static void renderInit(Side side){
        if(side == Side.CLIENT){
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockCobalt), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockSkyMod) blockCobalt).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(oreCobalt), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockSkyMod) oreCobalt).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(oreCopper), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockSkyMod) oreCopper).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(oreSilver), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockSkyMod) oreSilver).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(oreTitanium), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockSkyMod) oreTitanium).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(oreMagic), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockSkyMod) oreMagic).getUnlocalizedName().substring(5), "inventory"));

            renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockCopper), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockSkyMod) blockCopper).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockSilver), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockSkyMod) blockSilver).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockTitanium), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockSkyMod) blockTitanium).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockMagic), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockSkyMod) blockMagic).getUnlocalizedName().substring(5), "inventory"));

            renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockBlockBlockDiamond), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockSkyMod) blockBlockBlockDiamond).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockBlockDiamond), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((BlockSkyMod) blockBlockDiamond).getUnlocalizedName().substring(5), "inventory"));
        }
    }
}
