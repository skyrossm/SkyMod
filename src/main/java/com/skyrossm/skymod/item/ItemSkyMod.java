package com.skyrossm.skymod.item;

import com.skyrossm.skymod.creativetab.CreativeTab;
import com.skyrossm.skymod.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Skyrossm on 2/23/2016.
 */
public class ItemSkyMod extends Item{

    public ItemSkyMod(){
        super();
        setMaxStackSize(1);
        setCreativeTab(CreativeTab.SKYMOD_TAB);
        setNoRepair();
    }

    public ItemSkyMod(String itemName){
        this();
        setRegistryName(itemName);
        setUnlocalizedName(itemName);
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

}
