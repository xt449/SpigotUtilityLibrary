package com.github.xt449.bukkitutilitylibrary.example;

import com.github.xt449.bukkitutilitylibrary.EnchantmentUtility;
import com.github.xt449.bukkitutilitylibrary.gui.InventoryInterfaceBuilder;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author xt449
 */
public final class ExamplePlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		new ExampleConfiguration(this).initialize();

		final Enchantment effectEnchantment = new EffectEnchantment(this);

		if(EnchantmentUtility.registerEnchantment(effectEnchantment)) {
			new ExampleCommand(this, effectEnchantment).register();
		} else {
			getLogger().warning("Unable to register enchantment!");
		}

		new InventoryInterfaceBuilder(1, "", false).setClickHandler(event -> Bukkit.broadcastMessage("Click: " + event.getAction() + ", " + event.getClick() + ", " + event.getSlotType())).build();
	}
}
