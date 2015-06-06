package xt449.Utilities;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public abstract class UtilitiesConfiguration {

	private File file;
	protected YamlConfiguration config;

	protected abstract String getFileName();

	protected abstract String getHeader();

	protected abstract void setPathDefaults();

	protected abstract void getPathValues();

	public void initialize(Plugin plugin) {
		file = new File(plugin.getDataFolder(), getFileName());
		config = YamlConfiguration.loadConfiguration(file);
		/* configDefault = YamlConfiguration.loadConfiguration(new InputStreamReader(plugin.getResource("main.yml"))); */

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

		
		/* config.setDefaults(configDefault); */

		// This configuration save is only important for the first plugin
		// load or any paths removed by the user or added in a new version
		save();
	}

	private final void save() {
		try {
			config.save(file);
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
}
