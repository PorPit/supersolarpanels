package com.Denfop.item.Modules;

import java.util.List;

import com.Denfop.Config;
import com.Denfop.IUCore;
import com.Denfop.api.module.IModulGenDay;
import com.Denfop.api.module.IModulOutput;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ModuleGenerationDay extends Item implements IModulGenDay {
	public ModuleGenerationDay() {
		this.setCreativeTab((CreativeTabs) IUCore.tabssp1);
	}

	public int getItemStackLimit() {
		return this.maxStackSize;
	}

	public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
		info.add(StatCollector.translateToLocal("ssp.module1") + " +" + IModulGenDay.getData(itemStack).get(0) + "% "
				+ StatCollector.translateToLocal("ssp.module"));
		info.add(StatCollector.translateToLocal("ssp.modules"));

	}

	public void getSubItems(final Item item, final CreativeTabs tabs, final List itemList) {
		for (int meta = 0; meta <= 0; ++meta) {
			final ItemStack stack = new ItemStack((Item) this, 1, meta);
			IModulGenDay.setData(stack, Config.percent_day);
			itemList.add(stack);
		}
	}
}
