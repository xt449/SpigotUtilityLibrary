package xt449.Utilities;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import org.bukkit.plugin.java.JavaPlugin;
import xt449.Utilities.Command.DebugCommand;

public class Utilities extends JavaPlugin {
	
	public static final UUID uuid = UUID.fromString("817f9bc4-978f-3781-985d-1ed276c4a203");
	
	private static final String netherPrefix = "_nether";
	private static final String endPrefix = "_the_end";
	
	public static ItemStack debugItem = new ItemStack(Material.POISONOUS_POTATO);
	
	@Override
	public final void onLoad() {
		new UtilitiesEnchantment(UtilitiesEnchantment.EFFECT, 0, 0).register();
		debugItem.addEnchantment(Enchantment.getByName(UtilitiesEnchantment.EFFECT), 0);
	}
	
	@Override
	public final void onEnable() {
		new DebugCommand(this).register();
	}
	
	public static final String getCustomColorCodes(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}
	
	public static final World getOverworld(World world) {
		String name = world.getName();
		
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

	/*
	static {
		String name = "org.bukkit.craftbukkit.v1_8_2.CraftServer";
		name = name.substring("org.bukkit.craftbukkit".length()); // name = "v1_8_2.CraftServer"
		int versionLength = name.length() - "CraftServer".length(); 
		name = name.substring(0, versionLength); // basically replace ".CraftServer" with nothing
	}
	*/
}
