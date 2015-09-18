package xt449.Utilities;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public abstract class UtilitiesConfiguration {

	private Plugin plugin;
	private File file;
	protected YamlConfiguration config;

	public UtilitiesConfiguration(Plugin plugin) {
		this.plugin = plugin;
	}

	protected abstract String getFileName();

	protected abstract String getHeader();

	protected abstract void setPathDefaults();

	public abstract void getPathValues();

	public final void initialize() {
		file = new File(plugin.getDataFolder(), getFileName());
		config = YamlConfiguration.loadConfiguration(file);

		// Folder Setup:
		try {
			plugin.getDataFolder().mkdirs();
		} catch(SecurityException exc) {
			exc.printStackTrace();
		}

		// File Setup:
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch(IOException exc) {
				exc.printStackTrace();
			}
		}

		// Config Setup:
		config.options().copyDefaults(true);
		config.options().copyHeader(false);
		config.options().header(getHeader());

		setPathDefaults();

		getPathValues();

		// This configuration save is only important for the first plugin
		// load or any paths removed by the user or added in a new version
		save();
	}

	protected final void save() {
		try {
			config.save(file);
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}

	protected final Plugin getPlugin() {
		return plugin;
	}
}
