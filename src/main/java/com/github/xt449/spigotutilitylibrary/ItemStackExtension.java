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

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @author xt449
 *
 * Allows for single line ItemStack construction and initialization
 */
public class ItemStackExtension extends ItemStack {

	// Static

	private static final Field metaField;

	static {
		Field temp = null;

		try {
			temp = ItemStack.class.getDeclaredField("meta");
		} catch(NoSuchFieldException exc) {
			exc.printStackTrace();
		}

		metaField = temp;
	}

	// Instance

	public ItemStackExtension(Material material, int amount) {
		super(material, amount);

		try {
			metaField.setAccessible(true);
			metaField.set(this, Bukkit.getItemFactory().getItemMeta(material));
		} catch(IllegalAccessException exc) {
			exc.printStackTrace();
		}
	}

	public ItemStackExtension(Material material) {
		super(material);

		try {
			metaField.setAccessible(true);
			metaField.set(this, Bukkit.getItemFactory().getItemMeta(material));
		} catch(IllegalAccessException exc) {
			exc.printStackTrace();
		}
	}

	public ItemStackExtension unbreakable() {
		reflectItemMeta().setUnbreakable(true);
		return this;
	}

	public ItemStackExtension enchant(Enchantment enchantment, int level) {
		reflectItemMeta().addEnchant(enchantment, level, true);
		return this;
	}

	public ItemStackExtension name(String name) {
		reflectItemMeta().setDisplayName(name);
		return this;
	}

	public ItemStackExtension lore(List<String> lore) {
		reflectItemMeta().setLore(lore);
		return this;
	}

	public ItemStackExtension lore(String... lore) {
		reflectItemMeta().setLore(Arrays.asList(lore));
		return this;
	}

	private ItemMeta reflectItemMeta() {
		ItemMeta meta = null;

		try {
			metaField.setAccessible(true);
			meta = (ItemMeta) metaField.get(this);
		} catch(IllegalAccessException exc) {
			exc.printStackTrace();
		}

		return meta == null ? getItemMeta() : meta;
	}
}
