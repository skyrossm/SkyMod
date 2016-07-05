package com.skyrossm.skymod.item;

import java.util.List;

import com.skyrossm.skymod.creativetab.CreativeTab;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemVoidBucket extends ItemSkyMod{

	public ItemVoidBucket() {
		super("itemVoidBucket");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTab.SKYMOD_TAB);
	}

	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(worldIn, playerIn, true);
		if (movingobjectposition == null) {
			return itemStackIn;
		} else {
			if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
				BlockPos blockpos = movingobjectposition.getBlockPos();

				if (!worldIn.isBlockModifiable(playerIn, blockpos)) {
					return itemStackIn;
				}
				if (!playerIn.canPlayerEdit(blockpos.offset(movingobjectposition.sideHit), movingobjectposition.sideHit, itemStackIn)) {
					return itemStackIn;
				}
				IBlockState iblockstate = worldIn.getBlockState(blockpos);
				Material material = iblockstate.getBlock().getMaterial();
				if (material == Material.water) {
					worldIn.setBlockToAir(blockpos);
					playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
					return itemStackIn;
				}
				if (material == Material.lava) {
					worldIn.setBlockToAir(blockpos);
					playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
					return itemStackIn;
				}
			}
		}
		return itemStackIn;
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addInformation(ItemStack is, EntityPlayer player, List lore, boolean par1) {
		lore.add(EnumChatFormatting.DARK_AQUA + "Destroys any liquid picked up.");
	}
}
