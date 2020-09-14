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

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

/**
 * @author xt449
 */
public class InventoryInterfaceBuilder {

	private ClickHandler clickHandler = event -> {
	};
	private DragHandler dragHandler = event -> {
	};
	/*private CreativeHandler creativeHandler = event -> {};*/
	private OpenHandler openHandler = event -> {
	};
	private CloseHandler closeHandler = event -> {
	};

	private final InventoryInterface inventoryInterface;

	public InventoryInterfaceBuilder(int rows, @NotNull String title, boolean autoUpdate) {
		inventoryInterface = new AbstractInventoryInterface(rows, title, autoUpdate) {
			@Override
			public void onClick(@NotNull InventoryClickEvent event) {
				clickHandler.onClick(event);
			}

			@Override
			public void onDrag(@NotNull InventoryDragEvent event) {
				dragHandler.onDrag(event);
			}

			/*@Override
			public void onCreative(@NotNull InventoryCreativeEvent event) {
				creativeHandler.onCreative(event);
			}*/
			@Override
			public void onOpen(@NotNull InventoryOpenEvent event) {
				openHandler.onOpen(event);
			}

			@Override
			public void onClose(@NotNull InventoryCloseEvent event) {
				closeHandler.onClose(event);
			}
		};
	}

	public InventoryInterfaceBuilder(@NotNull Inventory inventory, boolean autoUpdate) {
		inventoryInterface = new AbstractInventoryInterface(inventory, autoUpdate) {
			@Override
			public void onClick(@NotNull InventoryClickEvent event) {
				clickHandler.onClick(event);
			}

			@Override
			public void onDrag(@NotNull InventoryDragEvent event) {
				dragHandler.onDrag(event);
			}

			@Override
			public void onOpen(@NotNull InventoryOpenEvent event) {
				openHandler.onOpen(event);
			}

			@Override
			public void onClose(@NotNull InventoryCloseEvent event) {
				closeHandler.onClose(event);
			}
		};
	}

	public InventoryInterfaceBuilder setClickHandler(@NotNull ClickHandler clickHandler) {
		this.clickHandler = clickHandler;
		return this;
	}

	public InventoryInterfaceBuilder setDragHandler(@NotNull DragHandler dragHandler) {
		this.dragHandler = dragHandler;
		return this;
	}

	/*public InventoryInterfaceBuilder setCreativeHandler(@NotNull CreativeHandler creativeHandler) {
		this.creativeHandler = creativeHandler;
		return this;
	}*/

	public InventoryInterfaceBuilder setOpenHandler(@NotNull OpenHandler openHandler) {
		this.openHandler = openHandler;
		return this;
	}

	public InventoryInterfaceBuilder setCloseHandler(@NotNull CloseHandler closeHandler) {
		this.closeHandler = closeHandler;
		return this;
	}

	public InventoryInterfaceHolder build() {
		return inventoryInterface.getHolder();
	}

	public interface ClickHandler {
		void onClick(@NotNull InventoryClickEvent event);
	}

	public interface DragHandler {
		void onDrag(@NotNull InventoryDragEvent event);
	}

	/*@Deprecated
	public static interface CreativeHandler {
		void onCreative(@NotNull InventoryCreativeEvent event);
	}*/
	public interface OpenHandler {
		void onOpen(@NotNull InventoryOpenEvent event);
	}

	public interface CloseHandler {
		void onClose(@NotNull InventoryCloseEvent event);
	}
}
