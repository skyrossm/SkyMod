package com.skyrossm.skymod.events;
import com.skyrossm.skymod.SkyMod;
import com.skyrossm.skymod.init.ModAchievements;
import com.skyrossm.skymod.init.ModItems;
import com.skyrossm.skymod.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class FMLCommonEventManager {
	@SubscribeEvent
	public void onCraft(PlayerEvent.ItemCraftedEvent event){
		if(event.crafting.getItem() == ModItems.itemDirtClump){
			event.player.addStat(ModAchievements.achDirtClump, 1);
		}
		if(event.crafting.getItem() == ModItems.itemRingFood){
			event.player.addStat(ModAchievements.achRingHunger, 1);
		}
		if(event.crafting.getItem() == ModItems.itemRingSuper){
			event.player.addStat(ModAchievements.achRingSuper, 1);
		}
		if(event.crafting.getItem() == ModItems.itemRingFly){
			event.player.addStat(ModAchievements.achRingFly, 1);
		}
		if(event.crafting.getItem() == ModItems.itemRingRegen){
			event.player.addStat(ModAchievements.achRingRegen, 1);
		}
		if(event.crafting.getItem() == ModItems.itemCloudNecklace){
			event.player.addStat(ModAchievements.achCloudNecklace, 1);
		}
	}
	
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event){
		if(!(FMLClientHandler.instance().getClient().currentScreen instanceof GuiChat) && FMLClientHandler.instance().getClient().world.isRemote){
			if(ClientProxy.superRing.isPressed()){
				SkyMod.proxy.openSuperRingGui();
			}
		}
		if(FMLClientHandler.instance().getClient().gameSettings.keyBindJump.isPressed()){
			SkyMod.proxy.jumpHelper();
		}
	}
}
