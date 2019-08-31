package xt449.bukkitutilitylibrary.example;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;
import xt449.bukkitutilitylibrary.EnchantmentUtility;

public final class ExamplePlugin extends JavaPlugin {

	private ExampleConfiguration exampleConfiguration;

	private ExampleCommand exampleCommand;

	private Enchantment effectEnchantment;

	@Override
	public void onEnable() {
		exampleConfiguration = new ExampleConfiguration(this);
		exampleConfiguration.initialize();

		effectEnchantment = new EffectEnchantment(this);
		EnchantmentUtility.registerEnchantment(effectEnchantment);

		exampleCommand = new ExampleCommand(this, effectEnchantment);
		exampleCommand.register();
	}
}
