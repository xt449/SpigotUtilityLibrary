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

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

/**
 * @author xt449
 */
public class ItemStackBuilder extends ItemStack {

	public ItemStackBuilder(Material material) {
		super(material);
	}

	public ItemStackBuilder(Material material, int amount) {
		super(material, amount);
	}

	public ItemStackBuilder unbreakable() {
		final ItemMeta meta = getItemMeta();
		meta.setUnbreakable(true);
		setItemMeta(meta);
		return this;
	}

	public ItemStackBuilder enchant(Enchantment enchantment, int level) {
		addUnsafeEnchantment(enchantment, level);
		return this;
	}

	public ItemStackBuilder name(String name) {
		final ItemMeta meta = getItemMeta();
		meta.setDisplayName(name);
		setItemMeta(meta);
		return this;
	}

	public ItemStackBuilder lore(List<String> lore) {
		final ItemMeta meta = getItemMeta();
		meta.setLore(lore);
		setItemMeta(meta);
		return this;
	}

	public ItemStackBuilder lore(String... lore) {
		final ItemMeta meta = getItemMeta();
		meta.setLore(Arrays.asList(lore));
		setItemMeta(meta);
		return this;
	}
}
