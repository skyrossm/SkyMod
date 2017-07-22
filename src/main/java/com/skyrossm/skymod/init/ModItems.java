package com.skyrossm.skymod.init;

import com.skyrossm.skymod.item.*;
import com.skyrossm.skymod.reference.Reference;
import com.skyrossm.skymod.util.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Skyrossm on 2/23/2016.
 */
public class ModItems {

    //Rings
    public static ItemSkyMod itemRing;
    public static ItemSkyMod itemGem;
    public static ItemSkyMod itemRingFly;
    public static ItemSkyMod itemAoL;
    public static ItemSkyMod itemRingRegen;
    public static ItemSkyMod itemRingHealth;
    public static ItemSkyMod itemRingFood;
    public static ItemSkyMod itemRingSuper;

    public static ItemSkyMod itemMagicDust;

    //Random
    public static ItemSkyMod itemVoidBucket;
    public static ItemSkyMod itemInfBucket;
    public static ItemSkyMod itemInfBucket2;
    public static Item itemDirtClump;
    public static ItemSkyMod itemCoalClump;
    public static Item itemSuperSword;
    public static ItemSkyMod itemCobaltShield;
    public static ItemSkyMod itemCobeltShield;
    public static ItemSkyMod itemCloudNecklace;

    //Silver
    public static ItemSkyMod itemSilverIngot;
    public static Item itemSilverSword;
    public static Item itemSilverPickaxe;
    public static Item itemSilverShovel;
    public static Item itemSilverAxe;
    public static Item itemSilverHoe;

    //Cobalt
    public static ItemSkyMod itemCobaltIngot;
    public static Item itemCobaltSword;
    public static Item itemCobaltPickaxe;
    public static Item itemCobaltShovel;
    public static Item itemCobaltAxe;
    public static Item itemCobaltHoe;

    //Copper
    public static ItemSkyMod itemCopperIngot;
    public static Item itemCopperSword;
    public static Item itemCopperPickaxe;
    public static Item itemCopperShovel;
    public static Item itemCopperAxe;
    public static Item itemCopperHoe;

    //Titanium
    public static ItemSkyMod itemTitaniumIngot;
    public static Item itemTitaniumSword;
    public static Item itemTitaniumPickaxe;
    public static Item itemTitaniumShovel;
    public static Item itemTitaniumAxe;
    public static Item itemTitaniumHoe;

    private static Item.ToolMaterial silverMaterial = EnumHelper.addToolMaterial("silverMaterial", 2, 761, 6.0F, 2.5F, 15);
    private static Item.ToolMaterial titaniumMaterial = EnumHelper.addToolMaterial("titaniumMaterial", 2, 900, 7.0F, 3.0F, 17);
    private static Item.ToolMaterial copperMaterial = EnumHelper.addToolMaterial("copperMaterial", 1, 250, 4.5F, 1.0F, 6);
    private static Item.ToolMaterial cobaltMaterial = EnumHelper.addToolMaterial("cobaltMaterial", 3, 2200, 10.0F, 5.0F, 18);
    private static Item.ToolMaterial dirtMaterial = EnumHelper.addToolMaterial("dirtMaterial", 0, 2, 2F, 0.5F, 0);
    private static Item.ToolMaterial superMaterial = EnumHelper.addToolMaterial("superMaterial", 3, -1, 30.0F, 10.0F, 1);

    public static void init(Side side) {

        //Rings
        itemRing = new ItemSkyMod("itemRing");
        itemRingFly = new ItemRingFly();
        itemRingRegen = new ItemRingRegen();
        itemRingHealth = new ItemRingHealth();
        itemRingFood = new ItemRingFood();
        itemRingSuper = new ItemRingSuper();
        itemAoL = new ItemAoL();
        itemGem = new ItemGem("d");

        itemMagicDust = new ItemSkyMod("itemMagicDust", 64);

        itemVoidBucket = new ItemVoidBucket();
        itemInfBucket = new ItemInfBucket(false, "itemInfBucket");
        itemInfBucket2 = new ItemInfBucket(true, "itemInfBucket2");
        itemDirtClump = new ItemSkyPickaxe(dirtMaterial, "itemDirtClump");
        itemCoalClump = new ItemSkyMod("itemCoalClump", 64);
        itemSuperSword = new ItemSkySword(superMaterial, "itemSuperSword");
        itemCobaltShield = new ItemSkyMod("itemCobaltShield");
        itemCobeltShield = new ItemCobeltShield();
        itemCloudNecklace = new ItemCloudNecklace();

        //Silver
        itemSilverIngot = new ItemSkyMod("itemSilverIngot", 64);
        itemSilverSword = new ItemSkySword(silverMaterial, "itemSilverSword");
        itemSilverPickaxe = new ItemSkyPickaxe(silverMaterial, "itemSilverPickaxe");
        itemSilverShovel = new ItemSkyShovel(silverMaterial, "itemSilverShovel");
        itemSilverAxe = new ItemSkyAxe(silverMaterial, "itemSilverAxe");
        itemSilverHoe = new ItemSkyHoe(silverMaterial, "itemSilverHoe");

        //Copper
        itemCopperIngot = new ItemSkyMod("itemCopperIngot", 64);
        itemCopperSword = new ItemSkySword(copperMaterial, "itemCopperSword");
        itemCopperPickaxe = new ItemSkyPickaxe(copperMaterial, "itemCopperPickaxe");
        itemCopperShovel = new ItemSkyShovel(copperMaterial, "itemCopperShovel");
        itemCopperAxe = new ItemSkyAxe(copperMaterial, "itemCopperAxe");
        itemCopperHoe = new ItemSkyHoe(copperMaterial, "itemCopperHoe");

        //Cobalt
        itemCobaltIngot = new ItemSkyMod("itemCobaltIngot", 64);
        itemCobaltSword = new ItemSkySword(cobaltMaterial, "itemCobaltSword");
        itemCobaltPickaxe = new ItemSkyPickaxe(cobaltMaterial, "itemCobaltPickaxe");
        itemCobaltShovel = new ItemSkyShovel(cobaltMaterial, "itemCobaltShovel");
        itemCobaltAxe = new ItemSkyAxe(cobaltMaterial, "itemCobaltAxe");
        itemCobaltHoe = new ItemSkyHoe(cobaltMaterial, "itemCobaltHoe");

        //Titanium
        itemTitaniumIngot = new ItemSkyMod("itemTitaniumIngot", 64);
        itemTitaniumSword = new ItemSkySword(titaniumMaterial, "itemTitaniumSword");
        itemTitaniumPickaxe = new ItemSkyPickaxe(titaniumMaterial, "itemTitaniumPickaxe");
        itemTitaniumShovel = new ItemSkyShovel(titaniumMaterial, "itemTitaniumShovel");
        itemTitaniumAxe = new ItemSkyAxe(titaniumMaterial, "itemTitaniumAxe");
        itemTitaniumHoe = new ItemSkyHoe(titaniumMaterial, "itemTitaniumHoe");

        registerItems(side, itemRing, itemRingFly, itemRingFood, itemRingHealth, itemRingRegen, itemRingSuper, itemAoL, itemGem, itemMagicDust,
                itemVoidBucket, itemInfBucket, itemInfBucket2, itemDirtClump, itemCoalClump, itemSuperSword, itemCobaltShield, itemCobeltShield,
                itemCloudNecklace, itemSilverIngot, itemSilverSword, itemSilverPickaxe, itemSilverShovel, itemSilverAxe, itemSilverHoe,
                itemCopperIngot, itemCopperSword, itemCopperPickaxe, itemCopperShovel, itemCopperAxe, itemCopperHoe, itemCobaltIngot,
                itemCobaltSword, itemCobaltPickaxe, itemCobaltShovel, itemCobaltAxe, itemCobaltHoe, itemTitaniumIngot, itemTitaniumSword,
                itemTitaniumPickaxe, itemTitaniumShovel, itemTitaniumAxe, itemTitaniumHoe);
        LogHelper.info("Loaded Items");
    }

    private static void registerItems(Side side, Item...items){
        for(Item item : items){
            GameRegistry.register(item);
            if(side == Side.CLIENT){
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
            }
        }
    }

}
