package com.skyrossm.skymod.init;

import com.skyrossm.skymod.item.ItemSkyMod;
import com.skyrossm.skymod.item.ItemTest;
import com.skyrossm.skymod.util.LogHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Skyrossm on 2/23/2016.
 */
public class ModItems {

    public static final ItemSkyMod testItem = new ItemTest();

    public static void init() {
        GameRegistry.registerItem(testItem);
        LogHelper.info("Loaded Items");
    }
}
