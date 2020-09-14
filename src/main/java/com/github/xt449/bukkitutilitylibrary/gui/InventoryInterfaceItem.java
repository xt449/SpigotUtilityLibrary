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

package com.github.xt449.bukkitutilitylibrary.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author xt449
 * @deprecated Update not planned
 */
@Deprecated
public class InventoryInterfaceItem {

	final ItemStack itemStack;
	private final Action action;

	public InventoryInterfaceItem(@NotNull ItemStack itemStack, @NotNull Action action) {
		this.itemStack = itemStack;
		this.action = action;
	}

	final void triggerAction(@NotNull InventoryClickEvent event) {
		this.action.onClick(event.getClickedInventory(), (Player) event.getWhoClicked(), event.getSlot(), event.getClick(), event.getHotbarButton());
	}

	public interface Action {
		/**
		 * @param inventory    The associated Inventory
		 * @param player       The associated Player
		 * @param slot         The associated slot value
		 * @param click        The associated ClickType
		 * @param hotbarButton The associated hot-bar button value
		 */
		void onClick(@Nullable Inventory inventory, @NotNull Player player, int slot, @NotNull ClickType click, int hotbarButton);
	}
}
