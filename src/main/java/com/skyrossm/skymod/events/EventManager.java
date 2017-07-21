package com.skyrossm.skymod.events;

import java.awt.Color;
import java.util.Random;

import com.skyrossm.skymod.SkyMod;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

import baubles.api.BaublesApi;

public class EventManager {
	
	int counter = 0;
	@SubscribeEvent
	public void livingUpdate(LivingUpdateEvent event){
		for(Object o : event.getEntity().getEntityWorld().playerEntities){
			EntityPlayer player = (EntityPlayer) o;
			if(player != null){
				
				NBTBase flyTag = player.getEntityData().getTag("skymod.fly");
				NBTBase hadflyTag = player.getEntityData().getTag("skymod.hadfly");
				if(hadflyTag == null){
					player.getEntityData().setBoolean("skymod.hadfly", false);
				}
				if(flyTag != null){
					if(player.getEntityData().getBoolean("skymod.fly")){
						player.capabilities.allowFlying = true;
						player.getEntityData().setBoolean("skymod.hadfly", true);
					}else{
						if(!player.capabilities.isCreativeMode && player.getEntityData().getBoolean("skymod.hadfly")){
							player.capabilities.allowFlying = false;
							player.capabilities.isFlying = false;
							player.getEntityData().setBoolean("skymod.hadfly", false);
						}
					}
				}
				NBTBase foodTag = player.getEntityData().getTag("skymod.food");
				if(foodTag != null){
					if(player.getEntityData().getBoolean("skymod.food")){
						if(player.getFoodStats().needFood()){
							player.getFoodStats().addStats(20, 1.0F);
						}
					}
				}
				NBTBase healthTag = player.getEntityData().getTag("skymod.health");
				if(healthTag != null){
					IAttributeInstance attributeinstance = player.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.MAX_HEALTH);
					if(player.getEntityData().getBoolean("skymod.health")){
			            try{
			            	if(attributeinstance.getModifier(SkyMod.globalID) == null){
			            		attributeinstance.applyModifier(new AttributeModifier(SkyMod.globalID, "skymod.health", 20.0D, 0));
			                }
			            }catch (Exception e){}
					}else{
				        try{
				        	if(attributeinstance.getModifier(SkyMod.globalID) != null){
				        		attributeinstance.removeModifier(attributeinstance.getModifier(SkyMod.globalID));
				        		player.setHealth(player.getMaxHealth());
				        	}
				        }catch (Exception e){}
					}
				}
				
				NBTBase regenTag = player.getEntityData().getTag("skymod.regen");
				if(regenTag != null){
					if(player.getEntityData().getBoolean("skymod.regen")){
						if(player.getHealth() < player.getMaxHealth() && !player.isDead && !(player.hurtTime > 0)){
							if(player.getHealth() != 0 && counter > 500){
								player.heal(1F);
								counter = 0;
							}
				        }
						counter++;
					}
				}
				NBTBase shieldTag = player.getEntityData().getTag("skymod.shield");
				if(shieldTag != null){
					IAttributeInstance knockbackinstance = player.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
					if(player.getEntityData().getBoolean("skymod.shield")){
						try{
							knockbackinstance.applyModifier(new AttributeModifier(SkyMod.globalID, "skymod.shield", 255, 0));
						}catch(Exception e){}
					}else{
						try{
							if(knockbackinstance.getModifier(SkyMod.globalID) != null){
								knockbackinstance.removeModifier(knockbackinstance.getModifier(SkyMod.globalID));
							}
						}catch(Exception e){}
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onJoin(EntityJoinWorldEvent event){
		if(event.getEntity() instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.getEntity();
			IAttributeInstance healthinstance = player.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.MAX_HEALTH);
			try{
				healthinstance.removeModifier(healthinstance.getModifier(SkyMod.globalID));
			}catch(Exception e){}
			IAttributeInstance knockbackinstance = player.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
			try{
				knockbackinstance.removeModifier(knockbackinstance.getModifier(SkyMod.globalID));
			}catch(Exception e){}
			try{
				healthinstance.removeModifier(healthinstance.getModifier(SkyMod.globalID));
			}catch(Exception e){}
			NBTBase healthTag = player.getEntityData().getTag("skymod.health");
			if(healthTag != null){
				if(player.getEntityData().getBoolean("skymod.health")){
					try{
						healthinstance.applyModifier(new AttributeModifier(SkyMod.globalID, "skymod.health", 20.0D, 0));
					}catch(Exception e){}
				}
			}
			NBTBase flyTag = player.getEntityData().getTag("skymod.fly");
			if(flyTag != null){
				if(player.getEntityData().getBoolean("skymod.fly")){
					player.capabilities.allowFlying = true;
					player.sendPlayerAbilities();
				}
			}
			NBTBase shieldTag = player.getEntityData().getTag("skymod.shield");
			if(shieldTag != null){
				if(player.getEntityData().getBoolean("skymod.shield")){
					try{
						knockbackinstance.applyModifier(new AttributeModifier(SkyMod.globalID, "skymod.shield", 255, 0));
					}catch(Exception e){}
				}
			}
		}
	}

	@SubscribeEvent(priority = EventPriority.LOW)
	public void onDeath(PlayerDropsEvent event){
		if(event.getEntityLiving() instanceof EntityPlayer){
			EntityPlayer p = event.getEntityPlayer();
			NBTBase aolTag = p.getEntityData().getTag("skymod.aol");
			if(aolTag != null){
				if(p.getEntityData().getBoolean("skymod.aol")){
					event.setCanceled(true);
				}
			}
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onDeath2(PlayerEvent.Clone event){
	    if(!event.isWasDeath()) return;
        EntityPlayer p = event.getEntityPlayer();
        NBTBase aolTag = p.getEntityData().getTag("skymod.aol");
        if(aolTag != null){
            if(p.getEntityData().getBoolean("skymod.aol")){
                p.inventory.copyInventory(event.getOriginal().inventory);
                p.getEntityData().setBoolean("skymod.aol", false);
                BaublesApi.getBaublesHandler(p).setStackInSlot(0, new ItemStack(Item.getItemFromBlock(Blocks.AIR)));
            }
        }
	}
	
    //@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent.Post event){
	    if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT){
            Minecraft mc = Minecraft.getMinecraft();
            ScaledResolution res = event.getResolution();
            FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
            fr.drawStringWithShadow("Testing", 2, 2, Color.MAGENTA.getRGB());
        }
	}
}
