package com.skyrossm.skymod.item;

import java.util.List;

import com.skyrossm.skymod.creativetab.CreativeTab;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemInfBucket extends ItemSkyMod{
	
	public boolean isLava;

	public ItemInfBucket(boolean flag, String name) {
		this.setMaxStackSize(1);
		this.isLava = flag;
        this.setCreativeTab(CreativeTab.SKYMOD_TAB);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
	}

    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(worldIn, playerIn, true);

        if (movingobjectposition == null)
        {
            return itemStackIn;
        }
        else
        {
            ItemStack ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, itemStackIn, movingobjectposition);
            if (ret != null) return ret;

            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                BlockPos blockpos = movingobjectposition.getBlockPos();

                if (!worldIn.isBlockModifiable(playerIn, blockpos))
                {
                    return itemStackIn;
                }
                BlockPos blockpos1 = blockpos.offset(movingobjectposition.sideHit);

                if (!playerIn.canPlayerEdit(blockpos1, movingobjectposition.sideHit, itemStackIn))
                {
                    return itemStackIn;
                }

                if (this.tryPlaceContainedLiquid(worldIn, blockpos1) && !playerIn.capabilities.isCreativeMode)
                {
                    playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
                    return new ItemStack(Items.bucket);
                }
            }
            return itemStackIn;
        }
    }

    public boolean tryPlaceContainedLiquid(World worldIn, BlockPos pos)
    {
        Material material = worldIn.getBlockState(pos).getBlock().getMaterial();
            boolean flag = !material.isSolid();

            if (!worldIn.isAirBlock(pos) && !flag)
            {
                return false;
            }
            else {
                if (worldIn.provider.doesWaterVaporize() && !this.isLava) {
                    int i = pos.getX();
                    int j = pos.getY();
                    int k = pos.getZ();
                    worldIn.playSoundEffect((double) ((float) i + 0.5F), (double) ((float) j + 0.5F), (double) ((float) k + 0.5F), "random.fizz", 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

                    for (int l = 0; l < 8; ++l) {
                        worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double) i + Math.random(), (double) j + Math.random(), (double) k + Math.random(), 0.0D, 0.0D, 0.0D, new int[0]);
                    }
                } else {
                    if (!worldIn.isRemote && flag && !material.isLiquid()) {
                        worldIn.destroyBlock(pos, true);
                    }

                    if (isLava) {
                        worldIn.setBlockState(pos, Blocks.flowing_lava.getDefaultState(), 3);
                    } else {
                        worldIn.setBlockState(pos, Blocks.flowing_water.getDefaultState(), 3);
                    }
                }
                return true;
            }
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List lore, boolean par1) {
	      lore.add(EnumChatFormatting.AQUA + "Filled with: " + (isLava ? EnumChatFormatting.RED + "Lava" : EnumChatFormatting.DARK_AQUA + "Water"));
	}
}
