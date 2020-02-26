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
