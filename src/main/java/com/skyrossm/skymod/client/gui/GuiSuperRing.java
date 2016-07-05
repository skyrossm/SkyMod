package com.skyrossm.skymod.client.gui;

import com.skyrossm.skymod.SkyMod;
import com.skyrossm.skymod.network.PacketHandler;
import com.skyrossm.skymod.network.message.PacketSuperRing;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;

public class GuiSuperRing extends GuiScreen{
	public static final int GUI_ID = 1;
	private GuiButton buttonFly;
	private GuiButton buttonHealth;
	private GuiButton buttonFood;
	private GuiButton buttonRegen;
	private GuiButton buttonClose;
	
	public static boolean flying = true;
	public static boolean health = true;
	public static boolean food = true;
	public static boolean regen = true; 
	
	public GuiSuperRing() {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		NBTBase flyTag = player.getEntityData().getTag("skymod.fly");
		NBTBase healthTag = player.getEntityData().getTag("skymod.health");
		NBTBase foodTag = player.getEntityData().getTag("skymod.food");
		NBTBase regenTag = player.getEntityData().getTag("skymod.regen");
    	if(flyTag != null){
    		System.out.println("Set!");
    		flying = player.getEntityData().getBoolean("skymod.fly");
    	}
    	if(healthTag != null){
    		health = player.getEntityData().getBoolean("skymod.health");
    	}
    	if(foodTag != null){
    		food = player.getEntityData().getBoolean("skymod.food");
    	}
    	if(regenTag != null){
    		regen = player.getEntityData().getBoolean("skymod.regen");
    	}	
	}

	
	@Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }
	
	@Override
	public void initGui(){
		buttonList.add(buttonFly = new GuiButton(0, this.width / 2 - 100, 80, "Flight: " + flying));
		buttonList.add(buttonHealth = new GuiButton(1, this.width / 2 - 100, 105, "Health Boost: " + health));
		buttonList.add(buttonFood = new GuiButton(2, this.width / 2 - 100, 130, "No Food: " + food));
		buttonList.add(buttonRegen = new GuiButton(3, this.width / 2 - 100, 155, "Regeneration: " + regen));
		buttonList.add(buttonClose = new GuiButton(4, this.width / 2 - 100, 200, "Close"));
	}
	
	@Override
    protected void actionPerformed(GuiButton btn) 
    {
		if (btn == buttonClose){
			mc.displayGuiScreen((GuiScreen)null);
     	}
		if (btn == buttonFly){
			flying = !flying;
			buttonFly.displayString = "Flight: " + flying;
     	}
		if (btn == buttonHealth){
			health = !health;
			buttonHealth.displayString = "Health Boost: " + health;
     	}
		if (btn == buttonFood){
			food = !food;
			buttonFood.displayString = "No Food: " + food;
     	}
		if (btn == buttonRegen){
			regen = !regen;
			buttonRegen.displayString = "Regeneration: " + regen;
     	}
    }
	
	@Override
	public void onGuiClosed(){
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		SkyMod.setPlayerData(player, flying, health, food, regen);
		PacketHandler.INSTANCE.sendToServer(new PacketSuperRing("set," + flying + "," +  health + "," +  food + "," + regen));
	}
	
	@Override
	public void drawScreen(int x, int y, float f){
		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRendererObj, "Super Ring Settings", this.width / 2, 40, 0xFFFFFFFF);
		super.drawScreen(x, y, f);
	}
}
