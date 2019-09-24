package xt449.bukkitutilitylibrary.gui;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

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
