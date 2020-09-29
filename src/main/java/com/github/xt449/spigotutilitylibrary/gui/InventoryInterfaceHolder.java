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
 *
 */

package com.github.xt449.spigotutilitylibrary.gui;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

/**
 * @author xt449
 */
public class InventoryInterfaceHolder implements InventoryHolder {

	Inventory inventory;
	InventoryInterface inventoryInterface;

	@NotNull
	@Override
	public final Inventory getInventory() {
		return this.inventory;
	}

	public final InventoryInterface getInventoryInterface() {
		return this.inventoryInterface;
	}
}
