package com.skyrossm.skymod.item;

import com.skyrossm.repackage.baubles.api.BaubleType;
import com.skyrossm.repackage.baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by Skyrossm on 2/23/2016.
 */
public class ItemAoL extends ItemSkyMod implements IBauble{

    public ItemAoL(){
        super("itemAoL");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.AMULET;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {}

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
        EntityPlayer p = (EntityPlayer) player;
        NBTTagCompound playerTag = p.getEntityData();
        playerTag.setBoolean("skymod.aol", true);
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
        EntityPlayer p = (EntityPlayer) player;
        NBTTagCompound playerTag = p.getEntityData();
        playerTag.setBoolean("skymod.aol", false);
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
