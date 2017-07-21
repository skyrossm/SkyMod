package com.skyrossm.skymod.init;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

/**
 * Created by Skyrossm on 7/4/2016.
 */
public class ModAchievements {

    public static Achievement achDirtClump;
    public static Achievement achRingHunger;
    public static Achievement achCobaltIngot;
    public static Achievement achRingSuper;
    public static Achievement achRingRegen;
    public static Achievement achRingFly;
    public static Achievement achCobaltShield;
    public static Achievement achRingHealth;
    public static Achievement achCloudNecklace;
    //public static Achievement achAmuletLoss;

    public static void init(){
        achDirtClump = new Achievement("achievement.dirtclump", "dirtClump", 0, 0, ModItems.itemDirtClump, (Achievement) null);
        achRingHunger = new Achievement("achievement.peaceful", "peaceful", 5, 0, ModItems.itemRingFood, (Achievement) null);
        achCobaltIngot = new Achievement("achievement.cobalt", "cobalt", 1, 0, ModItems.itemCobaltIngot, (Achievement) null);
        achRingSuper = new Achievement("achievement.superman", "superMan", 6, 0, ModItems.itemRingSuper, (Achievement) null); achRingSuper.setSpecial();
        achRingRegen = new Achievement("achievement.betterthanbrewing", "betterThanBrewing", 4, 0, ModItems.itemRingRegen, (Achievement) null);
        achRingFly = new Achievement("achievement.ibelieve", "iBelieve", 2, 0, ModItems.itemRingFly, (Achievement) null);
        achRingHealth = new Achievement("achievement.secondlife", "secondLife", 3, 0, ModItems.itemRingHealth, (Achievement) null);
        achCobaltShield = new Achievement("achievement.before", "before", 0, 1, ModItems.itemCobeltShield, (Achievement) null);
        achCloudNecklace = new Achievement("achievement.double", "double", 1, 1, ModItems.itemCloudNecklace, (Achievement) null);
        //achAmuletLoss = new Achievement("achievement.aol", "loss", 3, 1, ModItems.itemAoL, (Achievement) null);

        achDirtClump.registerStat();
        achRingHunger.registerStat();
        achCobaltIngot.registerStat();
        achRingSuper.registerStat();
        achRingRegen.registerStat();
        achRingFly.registerStat();
        achRingHealth.registerStat();
        achCobaltShield.registerStat();
        achCloudNecklace.registerStat();
       // achAmuletLoss.registerStat();
        AchievementPage.registerAchievementPage(new AchievementPage("SkyMod",
                new Achievement[] {achDirtClump, achRingHunger
                        , achCobaltIngot, achRingSuper, achRingRegen
                        , achRingFly, achRingHealth, achCobaltShield, achCloudNecklace/*, achAmuletLoss */
                }));
    }
}
