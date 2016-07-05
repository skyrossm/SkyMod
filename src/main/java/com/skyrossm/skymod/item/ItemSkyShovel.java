package com.skyrossm.skymod.item;

import com.skyrossm.skymod.creativetab.CreativeTab;
import net.minecraft.item.ItemSpade;

public class ItemSkyShovel extends ItemSpade{
	
	public ItemSkyShovel(ToolMaterial material, String name){
		super(material);
		this.setCreativeTab(CreativeTab.SKYMOD_TAB);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
}