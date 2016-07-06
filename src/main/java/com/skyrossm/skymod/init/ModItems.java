package com.skyrossm.skymod.init;

import com.skyrossm.skymod.item.*;
import com.skyrossm.skymod.reference.Reference;
import com.skyrossm.skymod.util.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
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

    public static void init() {

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


        //Rings
        GameRegistry.registerItem(itemRing);
        GameRegistry.registerItem(itemAoL);
        GameRegistry.registerItem(itemGem);
        GameRegistry.registerItem(itemRingFly);
        GameRegistry.registerItem(itemRingRegen);
        GameRegistry.registerItem(itemRingHealth);
        GameRegistry.registerItem(itemRingFood);
        GameRegistry.registerItem(itemRingSuper);

        GameRegistry.registerItem(itemMagicDust);

        //Random
        GameRegistry.registerItem(itemVoidBucket);
        GameRegistry.registerItem(itemInfBucket);
        GameRegistry.registerItem(itemInfBucket2);
        GameRegistry.registerItem(itemDirtClump);
        GameRegistry.registerItem(itemCoalClump);
        GameRegistry.registerItem(itemSuperSword);
        GameRegistry.registerItem(itemCobaltShield);
        GameRegistry.registerItem(itemCobeltShield);
        GameRegistry.registerItem(itemCloudNecklace);

        //Silver
        GameRegistry.registerItem(itemSilverIngot);
        GameRegistry.registerItem(itemSilverSword);
        GameRegistry.registerItem(itemSilverPickaxe);
        GameRegistry.registerItem(itemSilverShovel);
        GameRegistry.registerItem(itemSilverAxe);
        GameRegistry.registerItem(itemSilverHoe);

        //Copper
        GameRegistry.registerItem(itemCopperIngot);
        GameRegistry.registerItem(itemCopperSword);
        GameRegistry.registerItem(itemCopperPickaxe);
        GameRegistry.registerItem(itemCopperShovel);
        GameRegistry.registerItem(itemCopperAxe);
        GameRegistry.registerItem(itemCopperHoe);

        //Cobalt
        GameRegistry.registerItem(itemCobaltIngot);
        GameRegistry.registerItem(itemCobaltSword);
        GameRegistry.registerItem(itemCobaltPickaxe);
        GameRegistry.registerItem(itemCobaltShovel);
        GameRegistry.registerItem(itemCobaltAxe);
        GameRegistry.registerItem(itemCobaltHoe);

        //Titanium
        GameRegistry.registerItem(itemTitaniumIngot);
        GameRegistry.registerItem(itemTitaniumSword);
        GameRegistry.registerItem(itemTitaniumPickaxe);
        GameRegistry.registerItem(itemTitaniumShovel);
        GameRegistry.registerItem(itemTitaniumAxe);
        GameRegistry.registerItem(itemTitaniumHoe);

        LogHelper.info("Loaded Items");
    }

    public static void renderInit(Side side){
        if(side == Side.CLIENT) {
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

            renderItem.getItemModelMesher().register(ModItems.itemRing, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemRing).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemGem, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemGem).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemRingFly, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemRingFly).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemAoL, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemAoL).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemCloudNecklace, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemCloudNecklace).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemCobeltShield, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemCobeltShield).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemInfBucket, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemInfBucket).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemInfBucket2, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemInfBucket2).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemVoidBucket, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemVoidBucket).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemSuperSword, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemSuperSword).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemCobaltShield, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemCobaltShield).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemCoalClump, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemCoalClump).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemDirtClump, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemDirtClump).getUnlocalizedName().substring(5), "inventory"));

            renderItem.getItemModelMesher().register(ModItems.itemMagicDust, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemMagicDust).getUnlocalizedName().substring(5), "inventory"));

            renderItem.getItemModelMesher().register(ModItems.itemRingFood, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemRingFood).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemRingRegen, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemRingRegen).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemRingHealth, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemRingHealth).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemRingSuper, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemRingSuper).getUnlocalizedName().substring(5), "inventory"));

            renderItem.getItemModelMesher().register(ModItems.itemSilverAxe, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemSilverAxe).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemSilverPickaxe, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemSilverPickaxe).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemSilverHoe, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemSilverHoe).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemSilverIngot, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemSilverIngot).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemSilverShovel, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemSilverShovel).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemSilverSword, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemSilverSword).getUnlocalizedName().substring(5), "inventory"));

            renderItem.getItemModelMesher().register(ModItems.itemCopperAxe, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemCopperAxe).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemCopperPickaxe, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemCopperPickaxe).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemCopperHoe, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemCopperHoe).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemCopperIngot, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemCopperIngot).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemCopperShovel, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemCopperShovel).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemCopperSword, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemCopperSword).getUnlocalizedName().substring(5), "inventory"));

            renderItem.getItemModelMesher().register(ModItems.itemTitaniumAxe, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemTitaniumAxe).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemTitaniumHoe, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemTitaniumHoe).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemTitaniumIngot, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemTitaniumIngot).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemTitaniumPickaxe, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemTitaniumPickaxe).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemTitaniumShovel, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemTitaniumShovel).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemTitaniumSword, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemTitaniumSword).getUnlocalizedName().substring(5), "inventory"));

            renderItem.getItemModelMesher().register(ModItems.itemCobaltAxe, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemCobaltAxe).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemCobaltHoe, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemCobaltHoe).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemCobaltIngot, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemCobaltIngot).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemCobaltPickaxe, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemCobaltPickaxe).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemCobaltShovel, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemCobaltShovel).getUnlocalizedName().substring(5), "inventory"));
            renderItem.getItemModelMesher().register(ModItems.itemCobaltSword, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + (ModItems.itemCobaltSword).getUnlocalizedName().substring(5), "inventory"));


        }
    }
}
