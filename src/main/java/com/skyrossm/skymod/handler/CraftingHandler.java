package com.skyrossm.skymod.handler;

import com.skyrossm.skymod.init.ModBlocks;
import com.skyrossm.skymod.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class CraftingHandler
{
    public static void loadRecipes()
    {
        //Rings
        GameRegistry.addRecipe(new ShapelessOreRecipe(ModItems.itemRing, new Object[]{ "ingotCobalt", "ironIngot", Items.LAVA_BUCKET}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(ModItems.itemRing, new Object[]{ "ingotCobalt", "ingotSilver", Items.LAVA_BUCKET}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(ModItems.itemRingFly, new Object[]{ "blockDiamond", "blockCobalt", Items.FEATHER, ModItems.itemRing, ModBlocks.blockMagic, "gemDiamond"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(ModItems.itemRingRegen, new Object[]{ ModBlocks.blockBlockDiamond, "ingotCobalt", Items.BEEF, ModItems.itemRing, ModBlocks.blockMagic, "gemDiamond"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(ModItems.itemRingHealth, new Object[]{ "blockCobalt", Items.GOLDEN_APPLE, ModItems.itemRing, ModBlocks.blockMagic, "gemDiamond"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(ModItems.itemRingFood, new Object[]{ ModBlocks.blockBlockDiamond, "blockCobalt", Items.CAKE, ModItems.itemRing, ModBlocks.blockMagic, "gemDiamond"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(ModItems.itemRingSuper, new Object[]{ ModItems.itemRingFly, "gemDiamond", ModItems.itemRingFood, ModItems.itemRingHealth, ModItems.itemRingRegen, ModBlocks.blockBlockBlockDiamond, ModBlocks.blockMagic }));

        //Blocks
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemCobaltIngot, 9), new Object[]{ "blockCobalt"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemSilverIngot, 9), new Object[]{ "blockSilver"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemCopperIngot, 9), new Object[]{ "blockCopper"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemTitaniumIngot, 9), new Object[]{ "blockTitanium"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemMagicDust, 4), new Object[]{ ModBlocks.blockMagic}));

        //Silver
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemSilverAxe, true, new Object[]{ " XX", " YX", " Y ", 'X', "ingotSilver", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemSilverAxe, true, new Object[]{ "XX ", "XY ", " Y ", 'X', "ingotSilver", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemSilverPickaxe, true, new Object[]{ "XXX", " Y ", " Y ", 'X', "ingotSilver", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemSilverShovel, true, new Object[]{ " X ", " Y ", " Y ", 'X', "ingotSilver", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemSilverSword, true, new Object[]{ " X ", " X ", " Y ", 'X', "ingotSilver", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemSilverHoe, true, new Object[]{ " XX", " Y ", " Y ", 'X', "ingotSilver", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemSilverHoe, true, new Object[]{ "XX ", " Y ", " Y ", 'X', "ingotSilver", 'Y', "stickWood" }));

        //Cobalt
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemCobaltAxe, true, new Object[]{ " XX", " YX", " Y ", 'X', "ingotCobalt", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemCobaltAxe, true, new Object[]{ "XX ", "XY ", " Y ", 'X', "ingotCobalt", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemCobaltPickaxe, true, new Object[]{ "XXX", " Y ", " Y ", 'X', "ingotCobalt", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemCobaltShovel, true, new Object[]{ " X ", " Y ", " Y ", 'X', "ingotCobalt", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemCobaltSword, true, new Object[]{ " X ", " X ", " Y ", 'X', "ingotCobalt", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemCobaltHoe, true, new Object[]{ " XX", " Y ", " Y ", 'X', "ingotCobalt", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemCobaltHoe, true, new Object[]{ "XX ", " Y ", " Y ", 'X', "ingotCobalt", 'Y', "stickWood" }));

        //Copper
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemCopperAxe, true, new Object[]{ " XX", " YX", " Y ", 'X', "ingotCopper", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemCopperAxe, true, new Object[]{ "XX ", "XY ", " Y ", 'X', "ingotCopper", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemCopperPickaxe, true, new Object[]{ "XXX", " Y ", " Y ", 'X', "ingotCopper", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemCopperShovel, true, new Object[]{ " X ", " Y ", " Y ", 'X', "ingotCopper", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemCopperSword, true, new Object[]{ " X ", " X ", " Y ", 'X', "ingotCopper", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemCopperHoe, true, new Object[]{ " XX", " Y ", " Y ", 'X', "ingotCopper", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemCopperHoe, true, new Object[]{ "XX ", " Y ", " Y ", 'X', "ingotCopper", 'Y', "stickWood" }));

        //Titanium
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemTitaniumAxe, true, new Object[]{ " XX", " YX", " Y ", 'X', "ingotTitanium", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemTitaniumAxe, true, new Object[]{ "XX ", "XY ", " Y ", 'X', "ingotTitanium", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemTitaniumPickaxe, true, new Object[]{ "XXX", " Y ", " Y ", 'X', "ingotTitanium", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemTitaniumShovel, true, new Object[]{ " X ", " Y ", " Y ", 'X', "ingotTitanium", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemTitaniumSword, true, new Object[]{ " X ", " X ", " Y ", 'X', "ingotTitanium", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemTitaniumHoe, true, new Object[]{ " XX", " Y ", " Y ", 'X', "ingotTitanium", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemTitaniumHoe, true, new Object[]{ "XX ", " Y ", " Y ", 'X', "ingotTitanium", 'Y', "stickWood" }));

        //Blocks
        GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.blockCopper, true, new Object[]{ "XXX", "XXX", "XXX", 'X', "ingotCopper" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.blockSilver, true, new Object[]{ "XXX", "XXX", "XXX", 'X', "ingotSilver" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.blockCobalt, true, new Object[]{ "XXX", "XXX", "XXX", 'X', "ingotCobalt" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.blockTitanium, true, new Object[]{ "XXX", "XXX", "XXX", 'X', "ingotTitanium" }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.blockMagic, true, new Object[]{ "XX", "XX", 'X', ModItems.itemMagicDust }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.blockBlockDiamond, true, new Object[]{ "XZX", "ZXZ", "XZX", 'X', "blockDiamond", 'Z', Blocks.OBSIDIAN }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.blockBlockBlockDiamond, true, new Object[]{ "ZXZ", "XZX", "ZXZ", 'X', ModBlocks.blockBlockBlockDiamond, 'Z', Blocks.OBSIDIAN }));

        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.DIAMOND_BLOCK, 5), new Object[]{ ModBlocks.blockBlockDiamond });
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockBlockDiamond, 4), new Object[]{ ModBlocks.blockBlockBlockDiamond });

        //Items
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemDirtClump), new Object[]{ Blocks.DIRT, Blocks.DIRT, Blocks.DIRT }));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemCoalClump), new Object[]{ Items.COAL, Items.COAL, Items.COAL, Items.COAL, Items.COAL, Items.COAL, Items.COAL, Items.COAL}));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemSuperSword, true, new Object[]{ "RXR", "RXR", "OSO", 'X', ModBlocks.blockBlockBlockDiamond, 'R', Items.REDSTONE, 'O', Blocks.OBSIDIAN, 'S', "stickWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemVoidBucket, new Object[]{ "XYX", "CXC", 'X', Blocks.OBSIDIAN, 'Y', Items.ENDER_PEARL, 'C', Items.BLAZE_ROD }));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemInfBucket), new Object[]{ "gemDiamond", Items.WATER_BUCKET, "ingotCobalt" }));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemInfBucket2), new Object[]{ ModBlocks.blockBlockBlockDiamond, Items.LAVA_BUCKET, "blockCobalt" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemCobaltShield, true, new Object[]{ "RXR", "RCR", 'R', Blocks.OBSIDIAN, 'X', "blockCobalt", 'C', "ingotGold"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemCobeltShield), new Object[]{ ModItems.itemCobaltShield, Items.LEATHER}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemCloudNecklace), new Object[]{ "ingotCobalt", "ironIngot", ModBlocks.blockMagic}));
    }
}