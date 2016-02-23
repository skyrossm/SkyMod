package com.skyrossm.skymod.client.gui;

import com.skyrossm.skymod.handler.ConfigHandler;
import com.skyrossm.skymod.reference.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

/**
 * Created by Skyrossm on 2/22/2016.
 */
public class ModGuiConfig extends GuiConfig {
    public ModGuiConfig(GuiScreen parentScreen) {
        super(parentScreen,
                new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MOD_ID, false, false, "SkyMod Config");
    }
}
