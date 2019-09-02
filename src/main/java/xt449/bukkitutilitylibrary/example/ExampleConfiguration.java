package xt449.bukkitutilitylibrary.example;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import xt449.bukkitutilitylibrary.AbstractConfiguration;

import java.io.InputStreamReader;

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
