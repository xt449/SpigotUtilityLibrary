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

import java.util.Arrays;
import java.util.List;

/**
 * @author xt449
 * <p>
 * Allows for single line ItemStack construction and initialization
 * @deprecated Work in progress
 */
@Deprecated
public class ItemStackBuilder {

	// Instance

	public final Material material;
	public final int amount;
	public final ItemMeta meta;

	public ItemStackBuilder(Material material, int amount, ItemMeta meta) {
		this.material = material;
		this.amount = amount;
		this.meta = meta;
		if(!Bukkit.getItemFactory().isApplicable(meta, material)) {
			throw new IllegalArgumentException("");
		}
	}

	public ItemStackBuilder(Material material, int amount) {
		this.material = material;
		this.amount = amount;
		this.meta = Bukkit.getItemFactory().getItemMeta(material);
	}

	public ItemStackBuilder(Material material) {
		this.material = material;
		this.amount = 1;
		this.meta = Bukkit.getItemFactory().getItemMeta(material);
	}

	public ItemStackBuilder unbreakable() {
		meta.setUnbreakable(true);
		return this;
	}

	public ItemStackBuilder enchant(Enchantment enchantment, int level) {
		meta.addEnchant(enchantment, level, true);
		return this;
	}

	public ItemStackBuilder name(String name) {
		meta.setDisplayName(name);
		return this;
	}

	public ItemStackBuilder lore(List<String> lore) {
		meta.setLore(lore);
		return this;
	}

	public ItemStackBuilder lore(String... lore) {
		meta.setLore(Arrays.asList(lore));
		return this;
	}

	public ItemStack build() {
		final ItemStack itemStack = new ItemStack(material, amount);
		itemStack.setItemMeta(meta);

		return itemStack;
	}
}
