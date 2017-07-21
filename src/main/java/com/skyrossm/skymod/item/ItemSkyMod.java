package com.skyrossm.skymod.item;

import com.skyrossm.skymod.creativetab.CreativeTab;
import net.minecraft.item.Item;
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

    public ItemSkyMod(String itemName, int maxStackSize){
        this();
        setRegistryName(itemName);
        setUnlocalizedName(itemName);
        setMaxStackSize(maxStackSize);
    }

    public ItemSkyMod(String itemName, int maxStackSize, int maxDamage){
        this();
        setRegistryName(itemName);
        setUnlocalizedName(itemName);
        setMaxStackSize(maxStackSize);
        setMaxDamage(maxDamage);
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

}
