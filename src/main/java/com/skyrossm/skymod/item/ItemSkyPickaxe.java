package com.skyrossm.skymod.item;

import com.skyrossm.skymod.creativetab.CreativeTab;
import net.minecraft.item.ItemPickaxe;

public class ItemSkyPickaxe extends ItemPickaxe{
	
	public ItemSkyPickaxe(ToolMaterial mat, String name){
		super(mat);
		this.setCreativeTab(CreativeTab.SKYMOD_TAB);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
}