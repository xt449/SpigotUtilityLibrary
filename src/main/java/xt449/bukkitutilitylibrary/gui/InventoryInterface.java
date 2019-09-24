package xt449.bukkitutilitylibrary.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

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
