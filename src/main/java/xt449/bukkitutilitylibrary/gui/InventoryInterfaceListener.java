package xt449.bukkitutilitylibrary.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
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
			final Inventory clickedInventory = event.getClickedInventory();

			if(clickedInventory != null) {
				if(holder.getInventory() == clickedInventory) {
					((InventoryInterfaceHolder) holder).inventoryInterface.onClick(event);
				} else {
					((InventoryInterfaceHolder) holder).inventoryInterface.onEventInOtherInventory(clickedInventory, event);
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onInventoryDrag(InventoryDragEvent event) {
		final InventoryHolder holder = event.getView().getTopInventory().getHolder();
		if(holder instanceof InventoryInterfaceHolder) {
			final Inventory clickedInventory = event.getInventory();

			//if(clickedInventory != null) {
				if(holder.getInventory() == clickedInventory) {
					((InventoryInterfaceHolder) holder).inventoryInterface.onDrag(event);
				} else {
					((InventoryInterfaceHolder) holder).inventoryInterface.onEventInOtherInventory(clickedInventory, event);
				}
			//}
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
			final Inventory clickedInventory = event.getInventory();

			//if(clickedInventory != null) {
				if(holder.getInventory() == clickedInventory) {
					((InventoryInterfaceHolder) holder).inventoryInterface.onOpen(event);
				} else {
					((InventoryInterfaceHolder) holder).inventoryInterface.onEventInOtherInventory(clickedInventory, event);
				}
			//}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onInventoryClose(InventoryCloseEvent event) {
		final InventoryHolder holder = event.getView().getTopInventory().getHolder();
		if(holder instanceof InventoryInterfaceHolder) {
			final Inventory clickedInventory = event.getInventory();

			//if(clickedInventory != null) {
				if(holder.getInventory() == clickedInventory) {
					((InventoryInterfaceHolder) holder).inventoryInterface.onClose(event);
				} else {
					((InventoryInterfaceHolder) holder).inventoryInterface.onEventInOtherInventory(clickedInventory, event);
				}
			//}
		}
	}
}
