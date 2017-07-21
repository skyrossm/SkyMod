package com.skyrossm.skymod.item;

import java.util.List;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemRingFood extends ItemSkyMod implements IBauble{

	public ItemRingFood(){
		super("itemRingFood");
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		NBTTagCompound playerTag = player.getEntityData();
		playerTag.setBoolean("skymod.food", true);
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		NBTTagCompound playerTag = player.getEntityData();
		playerTag.setBoolean("skymod.food", false);
	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}
}
