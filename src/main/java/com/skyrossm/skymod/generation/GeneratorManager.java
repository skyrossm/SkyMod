package com.skyrossm.skymod.generation;

import java.util.Random;


import com.skyrossm.skymod.handler.ConfigHandler;
import com.skyrossm.skymod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class GeneratorManager implements IWorldGenerator
{
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.getDimensionId())
		{
			case -1:
				generateNether(world, random, chunkX * 16, chunkZ * 16);
			case 0:
				generateSurface(world, random, chunkX * 16, chunkZ * 16);
			case 1:
				generateEnd(world, random, chunkX * 16, chunkZ * 16);
			default:
				generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateEnd(World world, Random random, int x, int z){

	}

	private void generateSurface(World world, Random random, int x, int z){
		if(ConfigHandler.silverSpawn){
			this.addOreSpawn(ModBlocks.oreSilver, world, random, x, z, 16, 16, 4 + random.nextInt(3), 7, 5, 48);
		}
		if(ConfigHandler.copperSpawn){
			this.addOreSpawn(ModBlocks.oreCopper, world, random, x, z, 16, 16, 6 + random.nextInt(3), 14, 5, 256);
		}
		if(ConfigHandler.cobaltSpawn){
			this.addOreSpawn(ModBlocks.oreCobalt, world, random, x, z, 16, 16, 4 + random.nextInt(2), 1, 5, 32);
		}
		if(ConfigHandler.titaniumSpawn){
			this.addOreSpawn(ModBlocks.oreTitanium, world, random, x, z, 16, 16, 3 + random.nextInt(3), 7, 5, 24);
		}
		this.addOreSpawn(ModBlocks.oreMagic, world, random, x, z, 16, 16, 10 + random.nextInt(4), 5, 5, 256);
	}

	private void generateNether(World world, Random random, int x, int z){
		/*
		** 
		* int Xcoord = x + random.nextInt(16);
	    * int Ycoord = 10 + random.nextInt(128);
	    * int Zcoord = z + random.nextInt(16);
	    *(new WorldGenMinable(Tutorial.tutorialBlock, 1, 15, Blocks.netherrack)).generate(world, random, Xcoord, Ycoord, Zcoord);
	    **
	    */
	}

	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	{
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++)
		{
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block.getDefaultState(), maxVeinSize)).generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}
}