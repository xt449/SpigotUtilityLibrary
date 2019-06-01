package xt449.bukkitutilitylibrary.gui;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.UUID;

public class InventoryInterfaceHolder implements InventoryHolder {

	final UUID uuid = UUID.randomUUID();

	Inventory inventory;

	public final Inventory getInventory() {
		return this.inventory;
	}
}
