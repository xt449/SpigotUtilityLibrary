package de.albionco.shop.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

/**
 * Simple utility class to make dealing with CraftBukkit feel less like suicide.
 *
 * @author Connor Spencer Harries
 * @version 1.0.2
 */
public class Jailbird {
	private static final String CRAFTBUKKIT_LOC = "org.bukkit.craftbukkit";
	private static final String NMS_LOC = "net.minecraft.server";
	private static final String VERSION;

	static {
		Class<?> serverClass = Bukkit.getServer().getClass();

		if(!serverClass.getSimpleName().equals("CraftServer")) {
			VERSION = null;
		} else if(serverClass.getName().equals("org.bukkit.craftbukkit.CraftServer")) {
			VERSION = ".";
		} else {
			String name = serverClass.getName();
			name = name.substring("org.bukkit.craftbukkit".length());
			name = name.substring(0, name.length() - "CraftServer".length());
			VERSION = name;
		}

		if(VERSION == null) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Unable to detect CraftBukkit version");
		} else {
			Bukkit.getServer().getLogger().info(ChatColor.GREEN + "Detected CraftBukkit version (" + VERSION.replace(".", "").replace("_", ".") + ")");
		}
	}

	private Jailbird() {
	}

	public static Class<?> getCraftBukkitClass(String name) {
		if(VERSION == null) {
			throw new IllegalStateException("Unable to detect CraftBukkit version");
		}

		try {
			return Class.forName(CRAFTBUKKIT_LOC + VERSION + name);
		} catch(ClassNotFoundException e) {
			throw new IllegalArgumentException("\"" + name + "\" is not a CraftBukkit class!");
		}
	}

	public static Class<?> getNMSClass(String name) {
		if(VERSION == null) {
			throw new IllegalStateException("Unable to detect NMS version");
		}

		try {
			return Class.forName(NMS_LOC + VERSION + name);
		} catch(ClassNotFoundException e) {
			throw new IllegalArgumentException("\"" + name + "\" is not an NMS class!");
		}
	}

	public static String getVersion() {
		return VERSION;
	}
}
