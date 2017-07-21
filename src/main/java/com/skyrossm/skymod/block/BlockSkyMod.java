package com.skyrossm.skymod.block;

import com.skyrossm.skymod.creativetab.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Skyrossm on 2/24/2016.
 */
public class BlockSkyMod extends Block {
    public BlockSkyMod(){
        super(Material.ROCK);
        setCreativeTab(CreativeTab.SKYMOD_TAB);

    }

    public BlockSkyMod(String blockName){
        this();
        setRegistryName(blockName);
        setUnlocalizedName(blockName);
    }
}
