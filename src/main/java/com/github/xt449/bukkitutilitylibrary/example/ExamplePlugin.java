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
