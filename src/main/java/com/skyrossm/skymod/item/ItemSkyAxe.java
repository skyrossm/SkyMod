package com.skyrossm.skymod.item;

import com.skyrossm.skymod.creativetab.CreativeTab;
import net.minecraft.item.ItemAxe;

public class ItemSkyAxe extends ItemAxe{
	
	public ItemSkyAxe(ToolMaterial material, String name){
		super(material, material.getDamageVsEntity(), -3.0F);
		this.setCreativeTab(CreativeTab.SKYMOD_TAB);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
}