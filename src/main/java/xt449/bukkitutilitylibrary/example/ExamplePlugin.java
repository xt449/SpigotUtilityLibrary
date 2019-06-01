package xt449.bukkitutilitylibrary.example;

import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin {

	private ExampleConfiguration exampleConfiguration;

	@Override
	public void onEnable() {
		exampleConfiguration = new ExampleConfiguration(this);
		exampleConfiguration.initialize();
	}
}
