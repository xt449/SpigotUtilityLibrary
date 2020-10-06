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

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

/**
 * @author xt449
 */
public abstract class AbstractInventoryInterface implements InventoryInterface {

	private final InventoryInterfaceHolder holder = new InventoryInterfaceHolder();

	final boolean autoUpdate;

	AbstractInventoryInterface(@NotNull InventoryType inventoryType, @NotNull String title, boolean autoUpdate) {
		holder.inventory = Bukkit.createInventory(holder, inventoryType, title);
		holder.inventoryInterface = this;

		this.autoUpdate = autoUpdate;
	}

	AbstractInventoryInterface(int rows, @NotNull String title, boolean autoUpdate) {
		holder.inventory = Bukkit.createInventory(holder, rows * 9, title);
		holder.inventoryInterface = this;

		this.autoUpdate = autoUpdate;
	}

	@NotNull
	@Override
	public InventoryInterfaceHolder getHolder() {
		return holder;
	}

	@Override
	public void display(@NotNull Player player) {
		if(autoUpdate) {
			update();
		}

		player.openInventory(holder.inventory);
	}

	@Override
	public void onOpen(@NotNull InventoryOpenEvent event) {

	}

	@Override
	public void onClose(@NotNull InventoryCloseEvent event) {

	}

	@Override
	public void update() {

	}

	@Override
	public void onEventInOtherInventory(@NotNull Inventory inventory, @NotNull InventoryEvent event) {

	}
}
