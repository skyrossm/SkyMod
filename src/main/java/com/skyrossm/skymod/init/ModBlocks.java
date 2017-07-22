package com.skyrossm.skymod.init;

import com.skyrossm.skymod.block.BlockMagicOre;
import com.skyrossm.skymod.block.BlockSkyMod;
import com.skyrossm.skymod.block.BlockTest;
import com.skyrossm.skymod.reference.Reference;
import com.skyrossm.skymod.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
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
    public static final BlockSkyMod oreMagic = new BlockMagicOre();

    public static final BlockSkyMod blockBlockDiamond = new BlockSkyMod("blockBlockDiamond");
    public static final BlockSkyMod blockBlockBlockDiamond = new BlockSkyMod("blockBlockBlockDiamond");


    public static void init(Side side) {
        oreCobalt.setHardness(2F);
        oreSilver.setHardness(1F);
        oreCopper.setHardness(1F);
        oreTitanium.setHardness(5F);
        oreMagic.setHardness(1F);
        blockCobalt.setHardness(4F);
        blockCopper.setHardness(2F);
        blockSilver.setHardness(2F);
        blockMagic.setHardness(1F);
        blockTitanium.setHardness(10F);

        blockBlockBlockDiamond.setHardness(25F);
        blockBlockDiamond.setHardness(15F);
        registerBlocks(side, blockCopper, blockCobalt, blockSilver, blockTitanium, blockMagic, oreCobalt, oreSilver, oreCopper, oreTitanium, oreMagic, blockBlockBlockDiamond, blockBlockDiamond);
        LogHelper.info("Loaded Blocks");
    }

    private static void registerBlocks(Side side, Block...blocks){
        for(Block block : blocks){
            final ItemBlock itemBlock = new ItemBlock(block);
            GameRegistry.register(block);
            GameRegistry.register(itemBlock, block.getRegistryName());
            if(side == Side.CLIENT){
                ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
            }
        }
    }
}
