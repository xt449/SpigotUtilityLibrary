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

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryHolder;

/**
 * @author xt449
 */
public class InventoryInterfaceListener implements Listener {

	/*final EventPriority priority;

	InventoryInterfaceListener(EventPriority priority) {
		this.priority = priority;
	}*/

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onInventoryClick(InventoryClickEvent event) {
		final InventoryHolder holder = event.getView().getTopInventory().getHolder();
		if(holder instanceof InventoryInterfaceHolder) {
//			final Inventory clickedInventory = event.getClickedInventory();

//			if(clickedInventory != null) {
//				if(holder.getInventory() == clickedInventory) {
			((InventoryInterfaceHolder) holder).inventoryInterface.onClick(event);
//				} else {
//					((InventoryInterfaceHolder) holder).inventoryInterface.onEventInOtherInventory(clickedInventory, event);
//				}
//			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onInventoryDrag(InventoryDragEvent event) {
		final InventoryHolder holder = event.getView().getTopInventory().getHolder();
		if(holder instanceof InventoryInterfaceHolder) {
//			final Inventory clickedInventory = event.getInventory();

//			if(holder.getInventory() == clickedInventory) {
			((InventoryInterfaceHolder) holder).inventoryInterface.onDrag(event);
//			} else {
//				((InventoryInterfaceHolder) holder).inventoryInterface.onEventInOtherInventory(clickedInventory, event);
//			}
		}
	}

	/*@EventHandler(priority = EventPriority.HIGHEST)
	public void onInventoryCreative(InventoryCreativeEvent event) {
		final InventoryHolder holder = event.getView().getTopInventory().getHolder();
		if(holder instanceof InventoryInterfaceHolder) {
			final Inventory clickedInventory = event.getClickedInventory();

			if(clickedInventory != null) {
				if(holder.getInventory() == clickedInventory) {
					((InventoryInterfaceHolder) holder).inventoryInterface.onCreative(event);
				} else {
					((InventoryInterfaceHolder) holder).inventoryInterface.onEventInOtherInventory(clickedInventory, event);
				}
			}
		}
	}*/

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onInventoryOpen(InventoryOpenEvent event) {
		final InventoryHolder holder = event.getView().getTopInventory().getHolder();
		if(holder instanceof InventoryInterfaceHolder) {
//			final Inventory clickedInventory = event.getInventory();

//			if(holder.getInventory() == clickedInventory) {
			((InventoryInterfaceHolder) holder).inventoryInterface.onOpen(event);
//			} else {
//				((InventoryInterfaceHolder) holder).inventoryInterface.onEventInOtherInventory(clickedInventory, event);
//			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onInventoryClose(InventoryCloseEvent event) {
		final InventoryHolder holder = event.getView().getTopInventory().getHolder();
		if(holder instanceof InventoryInterfaceHolder) {
//			final Inventory clickedInventory = event.getInventory();

//			if(holder.getInventory() == clickedInventory) {
			((InventoryInterfaceHolder) holder).inventoryInterface.onClose(event);
//			} else {
//				((InventoryInterfaceHolder) holder).inventoryInterface.onEventInOtherInventory(clickedInventory, event);
//			}
		}
	}
}
