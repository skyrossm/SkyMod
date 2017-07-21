package com.skyrossm.skymod.handler;
import com.skyrossm.skymod.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {
    @Override
    public int getBurnTime(ItemStack fuel){
        if(fuel.getItem() == ModItems.itemCoalClump){
            return 12800;
        }
        if(fuel.getItem() == ModItems.itemMagicDust){
            return 1024;
        }
        return 0;
    }

}
