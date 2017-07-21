package com.skyrossm.skymod.item;

import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.skyrossm.skymod.creativetab.CreativeTab;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ItemVoidBucket extends ItemSkyMod{

	public ItemVoidBucket() {
		super("itemVoidBucket");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTab.SKYMOD_TAB);
	}

	/**
	 * Called when the equipped item is right clicked.
	 */
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, false);
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, itemstack, raytraceresult);
		if (ret != null) return ret;

		if (raytraceresult == null)
		{
			return new ActionResult(EnumActionResult.PASS, itemstack);
		}
		else if (raytraceresult.typeOfHit != RayTraceResult.Type.BLOCK)
		{
			return new ActionResult(EnumActionResult.PASS, itemstack);
		}
		else
		{
			BlockPos blockpos = raytraceresult.getBlockPos();

			if (!worldIn.isBlockModifiable(playerIn, blockpos))
			{
				return new ActionResult(EnumActionResult.FAIL, itemstack);
			}
			else
			{
				boolean flag1 = worldIn.getBlockState(blockpos).getBlock().isReplaceable(worldIn, blockpos);
				BlockPos blockpos1 = flag1 && raytraceresult.sideHit == EnumFacing.UP ? blockpos : blockpos.offset(raytraceresult.sideHit);

				if (!playerIn.canPlayerEdit(blockpos1, raytraceresult.sideHit, itemstack))
				{
					return new ActionResult(EnumActionResult.FAIL, itemstack);
				}
				else if (this.tryPlaceContainedLiquid(playerIn, worldIn, blockpos1))
				{
					playerIn.addStat(StatList.getObjectUseStats(this));
					return !playerIn.capabilities.isCreativeMode ? new ActionResult(EnumActionResult.SUCCESS, itemstack) : new ActionResult(EnumActionResult.SUCCESS, itemstack);
				}
				else
				{
					return new ActionResult(EnumActionResult.FAIL, itemstack);
				}
			}
		}
	}

	public boolean tryPlaceContainedLiquid(@Nullable EntityPlayer player, World worldIn, BlockPos posIn)
	{
		IBlockState iblockstate = worldIn.getBlockState(posIn);
		Material material = iblockstate.getMaterial();
		boolean flag = !material.isSolid();
		boolean flag1 = iblockstate.getBlock().isReplaceable(worldIn, posIn);

		if (!worldIn.isAirBlock(posIn) && !flag && !flag1)
		{
			return false;
		}
		else
		{
			if (!worldIn.isRemote && (flag || flag1) && !material.isLiquid())
			{
				worldIn.destroyBlock(posIn, true);
			}
			SoundEvent soundevent = SoundEvents.ITEM_BUCKET_EMPTY;
			worldIn.playSound(player, posIn, soundevent, SoundCategory.BLOCKS, 1.0F, 1.0F);
			worldIn.setBlockState(posIn, Blocks.AIR.getDefaultState(), 11);
		}
		return true;
	}

	@Override
	public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @Nullable net.minecraft.nbt.NBTTagCompound nbt) {
		if (this.getClass() == ItemVoidBucket.class)
		{
			return new net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
		}
		else
		{
			return super.initCapabilities(stack, nbt);
		}
	}

	public void addInformation(ItemStack is, EntityPlayer player, List lore, boolean par1) {
		lore.add(ChatFormatting.DARK_AQUA + "Destroys any liquid picked up.");
	}
}
