package com.skyrossm.skymod.item;

import java.util.List;
import java.util.Random;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.skyrossm.skymod.creativetab.CreativeTab;
import com.skyrossm.skymod.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemSkySword extends ItemSword{
	int superUses = 100000;
	
	public ItemSkySword(ToolMaterial material, String name){
		super(material);
		this.setCreativeTab(CreativeTab.SKYMOD_TAB);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
	
	@Override
	public EnumRarity getRarity(ItemStack is){
		if(is.getItem() == ModItems.itemSuperSword){
			return EnumRarity.EPIC;
		}else{
			return EnumRarity.COMMON;
		}
	}
	
	@Override
	public boolean hasEffect(ItemStack is){
		if(is.getItem() == ModItems.itemSuperSword){
			return true;
		}else{
			return false;
		}
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List lore, boolean par1) {
		if(is.getItem() == ModItems.itemSuperSword){
			lore.add(ChatFormatting.DARK_RED + "Some say it breaks randomly...");
		}
	}
	
	@Override
	public boolean hitEntity(ItemStack is, EntityLivingBase attacker, EntityLivingBase defender){
		if(is.getItem() == ModItems.itemSuperSword){
			superUses--;
			Random rand = new Random();
			if(rand.nextInt(superUses) == 1){
				this.setMaxDamage(1);
				this.setDamage(is, 1);
			}
		}
        return super.hitEntity(is, attacker, defender);
    }
}