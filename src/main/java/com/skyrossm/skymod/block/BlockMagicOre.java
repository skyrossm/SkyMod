package com.skyrossm.skymod.block;

import java.util.ArrayList;
import java.util.Random;

import com.skyrossm.skymod.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockMagicOre extends BlockSkyMod{

	public ArrayList<ItemStack> getDrops(World w, int x, int x1, int x2, int x3, int x4){
		Random rand = new Random();
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		drops.add(new ItemStack(ModItems.itemMagicDust, 4 + rand.nextInt(3)));
		return drops;
	}
}