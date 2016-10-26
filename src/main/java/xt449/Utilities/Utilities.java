package xt449.Utilities;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import xt449.Utilities.Command.DebugCommand;

public class Utilities extends JavaPlugin {
	
	private static final String netherPrefix = "_nether";
	private static final String endPrefix = "_the_end";
	
	@Override
	public final void onLoad() {
		new UtilitiesEnchantment(UtilitiesEnchantment.EFFECT, 0, 0).register();

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
	
	public static final World getOverworld(World world) {
		final String name = world.getName();
		
		if(name.endsWith(netherPrefix)) {
			World overworld = Bukkit.getServer().getWorld(world.getName().substring(0, world.getName().length() - 7));
			
			if(overworld != null) {
				return overworld;
			}
		}
		
		if(name.endsWith(endPrefix)) {
			World overworld = Bukkit.getServer().getWorld(world.getName().substring(0, world.getName().length() - 8));
			
			if(overworld != null) {
				return overworld;
			}
		}
		
		return world;
	}
	
	public static final World getNetherWorld(World world) {
		return Bukkit.getServer().getWorld(getOverworld(world).getName() + netherPrefix);
	}
	
	public static final World getEndWorld(World world) {
		return Bukkit.getServer().getWorld(getOverworld(world).getName() + endPrefix);
	}
}
