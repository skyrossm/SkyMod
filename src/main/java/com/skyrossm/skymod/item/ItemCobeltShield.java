package com.skyrossm.skymod.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import baubles.api.BaubleType;
import baubles.api.IBauble;

public class ItemCobeltShield extends ItemSkyMod implements IBauble{

	public ItemCobeltShield(){
		super("itemCobeltShield");
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.BELT;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		NBTTagCompound playerTag = player.getEntityData();
		playerTag.setBoolean("skymod.shield", true);
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		NBTTagCompound playerTag = player.getEntityData();
		playerTag.setBoolean("skymod.shield", false);
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
