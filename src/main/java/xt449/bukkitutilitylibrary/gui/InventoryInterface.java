package xt449.bukkitutilitylibrary.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class InventoryInterface {
	final Inventory inventory;
	private final InventoryInterfaceItem[] items;
	private final Player player;
	private final boolean autoUpdate;

	InventoryInterface(@NotNull Inventory inventory, @NotNull InventoryInterfaceItem[] items, @Nullable Player player, boolean autoUpdate) {
		this.inventory = inventory;
		this.items = items;
		this.player = player;
		this.autoUpdate = autoUpdate;
	}

	final void onClick(@NotNull InventoryClickEvent event) {
		InventoryInterfaceItem item = this.items[event.getSlot()];

		if(item != null) {
			item.triggerAction(event);
		}
	}

	public void displayTo(@NotNull Player player) {
		if(this.autoUpdate) {
			this.update();
		}

		player.openInventory(this.inventory);
	}

	public void display() {
		if(this.player != null) {
			if(this.autoUpdate) {
				this.update();
			}

			this.player.openInventory(this.inventory);
		}

	}

	public void update() {
		for(int slot = 0; slot < this.items.length; ++slot) {
			if(this.items[slot] instanceof UpdatingInventoryInterfaceItem) {
				this.inventory.setItem(slot, ((UpdatingInventoryInterfaceItem) this.items[slot]).triggerUpdate(this.player, this.inventory.getItem(slot)));
			}
		}
	}
}
