package xt449.bukkitutilitylibrary.gui;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class InventoryInterfaceHolder implements InventoryHolder {

	final UUID uuid = UUID.randomUUID();

	Inventory inventory;

	@NotNull
	@Override
	public final Inventory getInventory() {
		return this.inventory;
	}
}
