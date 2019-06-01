package xt449.bukkitutilitylibrary;

import org.bukkit.plugin.java.JavaPlugin;
import xt449.bukkitutilitylibrary.Command.DebugCommand;

public class Utilities extends JavaPlugin {
	
	@Override
	public final void onLoad() {
		UtilitiesEnchantment.register(this);

		// Log Plugin State
		getLogger().info("Plugin - Loaded!");
	}
	
	@Override
	public final void onEnable() {
		new DebugCommand(this).register();

		// Log Plugin State
		getLogger().info("Plugin - Enabled!");
	}

	@Override
	public final void onDisable() {
		// Log Plugin State
		getLogger().info("Plugin - Disabled!");
	}
}
