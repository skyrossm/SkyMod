package com.skyrossm.skymod.proxy;

import baubles.api.BaublesApi;
import com.skyrossm.skymod.client.gui.GuiSuperRing;
import com.skyrossm.skymod.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

/**
 * Created by Skyrossm on 2/22/2016.
 */
public class ClientProxy extends CommonProxy {
    public static KeyBinding superRing;

    @Override
    public void registerKeyBinds(){
        superRing = new KeyBinding("key.superring", Keyboard.KEY_K, "key.categories.skymod");
        ClientRegistry.registerKeyBinding(superRing);
    }

    @Override
    public void jumpHelper(){
        EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
        if(player.onGround == false){
            player.getEntityData().setBoolean("skymod.jump", true);
        }
    }

    @Override
    public void openSuperRingGui(){
        ItemStack slot1 = BaublesApi.getBaubles(FMLClientHandler.instance().getClient().thePlayer).getStackInSlot(1);
        ItemStack slot2 = BaublesApi.getBaubles(FMLClientHandler.instance().getClient().thePlayer).getStackInSlot(2);
        if(slot1 != null && slot1.getItem() == ModItems.itemRingSuper){
            Minecraft.getMinecraft().displayGuiScreen(new GuiSuperRing());
        }else if(slot2 != null && slot2.getItem() == ModItems.itemRingSuper){
            Minecraft.getMinecraft().displayGuiScreen(new GuiSuperRing());
        }

        //Minecraft.getMinecraft().thePlayer.openGui(SkyMod.instance, GuiSuperRing.GUI_ID, Minecraft.getMinecraft().thePlayer.worldObj, (int) Minecraft.getMinecraft().thePlayer.posX,
        //(int) Minecraft.getMinecraft().thePlayer.posY, (int) Minecraft.getMinecraft().thePlayer.posZ);
    }
}
