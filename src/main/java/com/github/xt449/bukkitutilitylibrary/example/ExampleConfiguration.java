/*
 * Copyright (c) 2020 xt449/BinaryBanana
 *
 * This file is part of BukkitUtilityLibrary.
 *
 * BukkitUtilityLibrary is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BukkitUtilityLibrary is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with BukkitUtilityLibrary.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package com.github.xt449.bukkitutilitylibrary.example;

import com.github.xt449.bukkitutilitylibrary.AbstractConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.InputStreamReader;

/**
 * @author xt449
 */
public final class ExampleConfiguration extends AbstractConfiguration {

	ExampleConfiguration(@NotNull final Plugin plugin) {
		super(plugin, "config.yml");

		header = "Example configuation header";
	}

	@Override
	protected void setDefaults() {
		config.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(plugin.getResource("plugin.yml"))));
	}

	@Override
	public void getValues() {
		if(plugin.getDescription().getAuthors().contains(config.getString("author"))) {
			plugin.getLogger().fine("Example Configuration: author not changed");
		}
	}
}
