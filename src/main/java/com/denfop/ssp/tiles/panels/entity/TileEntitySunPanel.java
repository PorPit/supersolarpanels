package com.denfop.ssp.tiles.panels.entity;


import com.denfop.ssp.common.Constants;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.core.init.Localization;
import ic2.core.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;

import javax.annotation.Nonnull;

public abstract class TileEntitySunPanel extends BasePanelTE {
	protected final int dayPower;

	public TileEntitySunPanel(SolarConfig config) {
		super(config);
		this.dayPower = config.dayPower;
	}

	@Nonnull
	@Override
	protected String getGuiDef() {
		return "solar_panel_sun";
	}

	protected void onLoaded() {
		super.onLoaded();
		if (!this.world.isRemote) {
			this.addedToEnet = !MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
			this.canRain = (this.world.getBiome(this.pos).canRain() || this.world.getBiome(this.pos).getRainfall() > 0.0F);
			this.hasSky = !this.world.provider.isNether();
		}
	}

	protected void onUnloaded() {
		super.onUnloaded();
		if (this.addedToEnet)
			this.addedToEnet = MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
	}

	protected void updateEntityServer() {
		super.updateEntityServer();

		if (this.active == GenerationState.DAY) {
			tryGenerateEnergy(this.dayPower);
		}
		if (this.storage > 0)
			this.storage = (int) (this.storage - this.chargeSlots.charge(this.storage));
	}

	public boolean getGuiState(String name) {
		if ("sunlight".equals(name))
			return (this.active == GenerationState.DAY);

		return super.getGuiState(name);
	}

	@Override
	public String getOutput() {
		if (this.active == GenerationState.DAY) {
			return String.format("%s %d %s", Localization.translate(Constants.MOD_ID + ".gui.generating"), this.dayPower, Localization.translate("ic2.generic.text.EUt"));
		}
		return String.format("%s 0 %s", Localization.translate(Constants.MOD_ID + ".gui.generating"), Localization.translate("ic2.generic.text.EUt"));
	}

	public static class SolarConfig extends BasePanelTE.SolarConfig {

		private final int dayPower;

		public SolarConfig(int dayPower, int maxStorage, int tier) {
			super(maxStorage, tier);
			this.dayPower = dayPower;
		}
	}
}
