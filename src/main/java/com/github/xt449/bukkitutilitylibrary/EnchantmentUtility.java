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

package com.github.xt449.bukkitutilitylibrary;

import org.bukkit.enchantments.Enchantment;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;

/**
 * @author xt449
 */
public class EnchantmentUtility {

	private static void prepareRegistration() {
		try {
			if(!Enchantment.isAcceptingRegistrations()) {
				final Field field = Enchantment.class.getDeclaredField("acceptingNew");
				field.setAccessible(true);
				field.set(null, true);
			}
		} catch(NoSuchFieldException | IllegalAccessException exc) {
			exc.printStackTrace();
		}
	}

	/**
	 * @param enchantment to be registered
	 * @return true if enchantment was registered successfully
	 * @throws IllegalArgumentException an enchantment with the same name or id already is registered.
	 */
	public static boolean registerEnchantment(@NotNull Enchantment enchantment) throws IllegalArgumentException {
		prepareRegistration();
		try {
			Enchantment.registerEnchantment(enchantment);
			return true;
		} catch(IllegalArgumentException ignored) {
			return false;
		}
	}
}
