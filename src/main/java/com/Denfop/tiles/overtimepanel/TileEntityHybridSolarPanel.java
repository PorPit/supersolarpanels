
package com.Denfop.tiles.overtimepanel;

import com.Denfop.Config;
import com.Denfop.IUCore;
import com.Denfop.tiles.base.TileEntitySolarPanel;

public class TileEntityHybridSolarPanel extends TileEntitySolarPanel {
	public TileEntityHybridSolarPanel() {
		super("blockHybridSolarPanel.name", 2, 0, Config.hGenDay, Config.hGenNight, Config.hOutput, Config.hStorage);
	}

}
