/*
 * Copyright (c) 2020 xt449/BinaryBanana
 *
 * This file is part of SpigotUtilityLibrary.
 *
 * SpigotUtilityLibrary is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SpigotUtilityLibrary is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SpigotUtilityLibrary.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.github.xt449.spigotutilitylibrary;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.InputStreamReader;

/**
 * @author xt449
 */
public abstract class AbstractConfiguration {

	protected final String filePath;
	private File file;

	protected final Plugin plugin;
	protected YamlConfiguration config;

	protected String header = null;

	protected AbstractConfiguration(@NotNull final Plugin plugin, @NotNull final String filePath) {
		this.plugin = plugin;
		this.filePath = filePath;
	}

	protected void writeDefaults() {
		try {
			config.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(plugin.getResource(filePath))));
		} catch(Exception exc) {
			plugin.getLogger().warning("Unable to load defaults for configuration file '" + filePath + "' from '" + plugin.getName() + "'!");
		}
	}

	protected void readValues() {

	}

	/**
	 * @deprecated Use {@link AbstractConfiguration#writeDefaults()}
	 */
	@Deprecated
	protected abstract void setDefaults();

	/**
	 * @deprecated Use {@link AbstractConfiguration#readValues()}
	 */
	@Deprecated
	protected abstract void getValues();

	public final void initialize() {
		file = new File(plugin.getDataFolder(), filePath);
		config = YamlConfiguration.loadConfiguration(file);

		// Folder Setup:
		if(!plugin.getDataFolder().exists()) {
			try {
				if(!plugin.getDataFolder().mkdirs()) {
					throw new Exception();
				}
			} catch(Exception exc) {
				plugin.getLogger().warning("Unable to create path to configuration file '" + filePath + "'!");
			}
		}

		// File Setup:
		if(!file.exists()) {
			try {
				if(!file.createNewFile()) {
					throw new Exception();
				}
			} catch(Exception exc) {
				plugin.getLogger().warning("Unable to create configuration file '" + filePath + "'!");
			}
		}

		// Config Setup:
		config.options().copyDefaults(true);
		config.options().copyHeader(false);
		config.options().header(header);

		setDefaults();
		writeDefaults();

		getValues();
		readValues();

		// This configuration save is only important for the first plugin
		// load or any paths removed by the user or added in a new version
		save();
	}

	protected void save() {
		try {
			config.save(file);
		} catch(Exception exc) {
			plugin.getLogger().warning("Unable to save configuration file '" + filePath + "'!");
		}
	}
}
