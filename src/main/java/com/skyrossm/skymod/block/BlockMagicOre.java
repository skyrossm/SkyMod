package com.skyrossm.skymod.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.skyrossm.skymod.init.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.IWorldAccess;
import net.minecraft.world.World;

public class BlockMagicOre extends BlockSkyMod{

    public BlockMagicOre(){ super("oreMagic");}

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune) {
        return ModItems.itemMagicDust;
    }

    @Override
    public int quantityDropped(Random random) {
        Random rand = new Random();
        return 4 + rand.nextInt(3);
    }
}