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

package com.github.xt449.spigotutilitylibrary.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

/**
 * @author xt449
 */
public interface InventoryInterface {
	@NotNull InventoryInterfaceHolder getHolder();

	default void display(@NotNull Player player) {
		player.openInventory(getHolder().inventory);
	}

	void update();

	/*void onClick(@NotNull InventoryClickEvent event);

	default ClickHandler clickHandler = new ClickHandler() {
		@Override
		public void onClick(@NotNull InventoryClickEvent event) {
			event.setCancelled(true);
		}
	};*/

	void onEventInOtherInventory(@NotNull Inventory inventory, @NotNull InventoryEvent event);

	default void onClick(@NotNull InventoryClickEvent event) {
		event.setCancelled(true);
	}

	default void onDrag(@NotNull InventoryDragEvent event) {
		event.setCancelled(true);
	}

	/*@Deprecated
	default void onCreative(@NotNull InventoryCreativeEvent event) {
		event.setCancelled(true);
	}*/

	void onOpen(@NotNull InventoryOpenEvent event);

	void onClose(@NotNull InventoryCloseEvent event);
}
