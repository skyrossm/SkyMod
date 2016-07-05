package com.skyrossm.skymod.events;

import java.awt.Color;
import java.util.Random;

import com.skyrossm.skymod.SkyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
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
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

import baubles.api.BaublesApi;

public class EventManager {
	
	int counter = 0;
	@SubscribeEvent
	public void livingUpdate(LivingUpdateEvent event){
		for(Object o : event.entity.worldObj.playerEntities){
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
					IAttributeInstance attributeinstance = player.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth);
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
					IAttributeInstance knockbackinstance = player.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.knockbackResistance);
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
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			IAttributeInstance healthinstance = player.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth);
			try{
				healthinstance.removeModifier(healthinstance.getModifier(SkyMod.globalID));
			}catch(Exception e){}
			IAttributeInstance knockbackinstance = player.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.knockbackResistance);
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

	@SubscribeEvent
	public void onDeath(PlayerDropsEvent event){
		if(event.entityLiving instanceof EntityPlayer){
			EntityPlayer p = (EntityPlayer) event.entityLiving;
			NBTBase aolTag = p.getEntityData().getTag("skymod.aol");
			if(aolTag != null){
				if(p.getEntityData().getBoolean("skymod.aol")){
					event.drops.clear();
				}
			}
		}
	}

	@SubscribeEvent
	public void onDeath2(PlayerEvent.Clone event){
		if(event.entityLiving instanceof EntityPlayer){
			EntityPlayer p = (EntityPlayer) event.entityLiving;
			NBTBase aolTag = p.getEntityData().getTag("skymod.aol");
			if(aolTag != null){
				if(p.getEntityData().getBoolean("skymod.aol")){
					p.inventory.copyInventory(event.original.inventory);
					p.getEntityData().setBoolean("skymod.aol", false);
					BaublesApi.getBaubles(p).removeStackFromSlot(0);
				}
			}
		}
	}
	
	/*@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent.Post event){
		int height = Minecraft.getMinecraft().displayHeight;
		int width = Minecraft.getMinecraft().displayWidth;
		if(event.type == event.type.HELMET && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0){
			if(Minecraft.getMinecraft().thePlayer.getCurrentArmor(3) != null && Minecraft.getMinecraft().thePlayer.getCurrentArmor(3).getItem() == SkyMod.itemCoolShades){
				Tessellator tessellator = Tessellator.instance;
				Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(SkyMod.MODID + ":textures/armor/overlay/" + "coolShades.png"));
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE_MINUS_SRC_ALPHA);
		        tessellator.startDrawingQuads();
		        tessellator.addVertexWithUV(0.0D, height / 2 + height / 3.35, 0.0D, 0.0D, 1.D);
		        tessellator.addVertexWithUV(width / 2.00, height / 2 + height / 3.35, 0.0D, 1.0D, 1.0D);
		        tessellator.addVertexWithUV(width / 2.00, 0.0D, 0.0D, 1.0D, 0.0D);
		        tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
		        tessellator.draw();
				GL11.glDisable(GL11.GL_BLEND);	
			}
		}
	}*/
}
