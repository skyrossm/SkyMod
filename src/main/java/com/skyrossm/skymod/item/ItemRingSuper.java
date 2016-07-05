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

public class ItemRingSuper extends ItemSkyMod implements IBauble{

	public ItemRingSuper(){
		super("itemRingSuper");
	}
	
	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}
	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		EntityPlayer p = (EntityPlayer) player;
		setAbilites(p, false, false, false, false);
	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		EntityPlayer p = (EntityPlayer) player;
		setAbilites(p, true, true, true, true);
	}
	
	public static void setAbilites(EntityPlayer player, boolean flight, boolean health, boolean food, boolean regen){
		NBTTagCompound playerTag = player.getEntityData();
		playerTag.setBoolean("skymod.fly", flight);
		playerTag.setBoolean("skymod.health", health);
		playerTag.setBoolean("skymod.food", food);
		playerTag.setBoolean("skymod.regen", regen);
	}
	
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {	}
}
