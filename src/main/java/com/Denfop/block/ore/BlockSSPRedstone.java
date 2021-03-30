package com.Denfop.block.ore;

import java.util.Random;

import com.Denfop.IUCore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.block.Block;

public class BlockSSPRedstone extends Block {

	public BlockSSPRedstone(Material material) {
		super(material);
		this.setCreativeTab(IUCore.tabssp4);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(1F);
		this.setLightLevel(0.3F);
		this.setStepSound(Block.soundTypeGlass);
	}

	public int quantityDropped(Random random) {
		return 2 + random.nextInt(2);
	}

	public int quantityDroppedWithBonus(int fortune, Random random) {
		return (fortune == 0) ? quantityDropped(random)
				: (quantityDropped(random) + fortune + random.nextInt(fortune * 2));
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return Items.redstone;
	}
}
