package com.skyrossm.skymod.item;

import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import baubles.api.BaubleType;
import baubles.api.IBauble;

import java.util.Random;

public class ItemCloudNecklace extends ItemSkyMod implements IBauble{

	private boolean canDoubleJump = true;
	private boolean hasJumped = false;

    public ItemCloudNecklace(){
        super("itemCloudNecklace");
    }
	
	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.AMULET;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		EntityPlayer p = (EntityPlayer) player;
		if(!p.getEntityData().getBoolean("skymod.jump") && hasJumped){
			p.fallDistance = 0;
		}
		if(p.onGround){
			canDoubleJump = true;
			hasJumped = false;
		}
		if(canDoubleJump){
			NBTBase jumpTag = p.getEntityData().getTag("skymod.jump");
			if(jumpTag != null){
				if(p.getEntityData().getBoolean("skymod.jump") && hasJumped){
					p.motionY = 0.5;
					p.fallDistance = 0;
					p.getEntityData().setBoolean("skymod.jump", false);
					canDoubleJump = false;
                    Random rand = new Random();
					p.getEntityWorld().spawnParticle(EnumParticleTypes.SMOKE_NORMAL, p.getPosition().getX(), p.getPosition().getY(), p.getPosition().getZ(), 0D, 0D, 0D);
                    for(int i = 1;i < 16;i++){
                        p.getEntityWorld().spawnParticle(EnumParticleTypes.SMOKE_NORMAL, p.getPosition().getX(), p.getPosition().getY(), p.getPosition().getZ(), 0D + rand.nextInt(i), 0D + rand.nextInt(i), 0D + rand.nextInt(i));
                    }
				}else{
					hasJumped = true;
				}
			}
		}
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}
	
}
