package com.Denfop.tiles.Mechanism;

import java.util.EnumSet;
import java.util.Set;

import com.Denfop.InvSlot.InvSlotProcessableMultiSmelting;
import com.Denfop.container.ContainerMultiMachine;
import com.Denfop.gui.GuiMultiMachine;
import com.Denfop.tiles.base.TileEntityMultiMachine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.upgrade.UpgradableProperty;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;

public class TileEntityQuadElectricFurnace extends TileEntityMultiMachine {
	public TileEntityQuadElectricFurnace() {
		super();
		this.inputSlots = new InvSlotProcessableMultiSmelting(this, "input", sizeWorkingSlot);
	}

	@Override
	protected EnumMultiMachine getMachine() {
		return EnumMultiMachine.QUAD_ELECTRIC_FURNACE;
	}

	public String getInventoryName() {
		return StatCollector.translateToLocal("ssp.blockElecFurnace3.name");
	}

	public String getStartSoundFile() {
		return "Machines/Electro Furnace/ElectroFurnaceLoop.ogg";
	}

	public String getInterruptSoundFile() {
		return null;
	}

	public Set<UpgradableProperty> getUpgradableProperties() {
		return EnumSet.of(UpgradableProperty.Processing, UpgradableProperty.Transformer,
				UpgradableProperty.EnergyStorage, UpgradableProperty.ItemConsuming, UpgradableProperty.ItemProducing);
	}
}
