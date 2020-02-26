package com.github.xt449.bukkitutilitylibrary.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

/**
 * @author xt449
 */
public abstract class AbstractInventoryInterface implements InventoryInterface {

	private final InventoryInterfaceHolder holder = new InventoryInterfaceHolder();

	final int size;
	//final Inventory inventory;
	final boolean autoUpdate;

	AbstractInventoryInterface(@NotNull Inventory inventory, boolean autoUpdate) {
		size = inventory.getSize();

		holder.inventory = inventory;
		holder.inventoryInterface = this;
		//this.inventory = inventory;

		this.autoUpdate = autoUpdate;
	}

	AbstractInventoryInterface(int rows, @NotNull String title, boolean autoUpdate) {
		size = rows * 9;

		holder.inventory = Bukkit.createInventory(holder, size, title);
		holder.inventoryInterface = this;
		//this.inventory = inventory;

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
