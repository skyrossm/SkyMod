package com.skyrossm.skymod.handler;

import com.skyrossm.skymod.init.ModBlocks;
import com.skyrossm.skymod.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Skyrossm on 7/4/2016.
 */
public class SmeltingHandler {
    public static void loadRecipes(){
        //Silver
        GameRegistry.addSmelting(ModBlocks.oreSilver, new ItemStack(ModItems.itemSilverIngot), 2F);

        //Copper
        GameRegistry.addSmelting(ModBlocks.oreCopper, new ItemStack(ModItems.itemCopperIngot), 1F);

        //Cobalt
        GameRegistry.addSmelting(ModBlocks.oreCobalt, new ItemStack(ModItems.itemCobaltIngot), 5F);

        //Titanium
        GameRegistry.addSmelting(ModBlocks.oreTitanium, new ItemStack(ModItems.itemTitaniumIngot), 3F);
    }
}
