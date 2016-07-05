package com.skyrossm.skymod.item;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by Skyrossm on 2/23/2016.
 */
public class ItemRingFly extends ItemSkyMod implements IBauble {

    public ItemRingFly(){
        super("itemRingFly");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.RING;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {}

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
        EntityPlayer p = (EntityPlayer) player;
        NBTTagCompound playerTag = p.getEntityData();
        playerTag.setBoolean("skymod.fly", true);
        System.out.println("Helo");
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
        EntityPlayer p = (EntityPlayer) player;
        NBTTagCompound playerTag = p.getEntityData();
        playerTag.setBoolean("skymod.fly", false);
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
