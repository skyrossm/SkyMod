package com.skyrossm.skymod.creativetab;

import com.skyrossm.skymod.init.ModItems;
import com.skyrossm.skymod.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Skyrossm on 2/23/2016.
 */
public class CreativeTab {
    public static final CreativeTabs SKYMOD_TAB = new CreativeTabs(Reference.MOD_ID)
    {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.itemCloudNecklace, 1);
        }
    };
}
