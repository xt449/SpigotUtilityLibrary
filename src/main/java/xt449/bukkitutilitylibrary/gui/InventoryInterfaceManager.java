package xt449.bukkitutilitylibrary.gui;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class InventoryInterfaceManager {

	private static BiMap<UUID, InventoryInterface> inventoryInterfaces = HashBiMap.create(2);
	private static boolean initialized = false;

	public static void initialize(@NotNull final Plugin plugin) {
		if(!initialized) {
			Bukkit.getPluginManager().registerEvents(new Listener() {
				@EventHandler(priority = EventPriority.HIGHEST)
				public final void onInventoryClick(final InventoryClickEvent event) {
					if(event.getView().getTopInventory().getHolder() instanceof InventoryInterfaceHolder) {
						event.setCancelled(true);
						event.setResult(Event.Result.DENY);
						if(event.getClickedInventory() == event.getView().getTopInventory()) {
							InventoryInterfaceManager.getInventoryInterface((InventoryInterfaceHolder) event.getClickedInventory().getHolder()).onClick(event);
						}
					}

				}

				@EventHandler(priority = EventPriority.HIGHEST)
				public final void onInventoryDrag(final InventoryDragEvent event) {
					if(event.getView().getTopInventory().getHolder() instanceof InventoryInterfaceHolder) {
						event.setCancelled(true);
						event.setResult(Event.Result.DENY);
					}
				}
			}, plugin);

			initialized = true;
		}
	}

	static void register(@NotNull final InventoryInterface inventoryInterface) {
		if(!initialized) {
			throw new IllegalStateException("InventoryInterfaceManager has not been initialized by any plugin!");
		} else {
			if(inventoryInterface.inventory.getHolder() instanceof InventoryInterfaceHolder) {
				inventoryInterfaces.put(((InventoryInterfaceHolder) inventoryInterface.inventory.getHolder()).uuid, inventoryInterface);
			} else {
				throw new IllegalArgumentException("Parameter inventoryInterface was not built properly!");
			}
		}
	}

	@NotNull
	static InventoryInterface register(@NotNull final UUID uuid, @NotNull final InventoryInterface inventoryInterface) {
		if(!initialized) {
			throw new IllegalStateException("InventoryInterfaceManager has not been initialized by any plugin!");
		} else {
			inventoryInterfaces.put(uuid, inventoryInterface);
			return inventoryInterface;
		}
	}

	public static boolean unregister(@NotNull final InventoryInterface inventoryInterface) {
		return inventoryInterfaces.inverse().remove(inventoryInterface) != null;
	}

	@Nullable
	private static InventoryInterface getInventoryInterface(@NotNull final InventoryInterfaceHolder holder) {
		return inventoryInterfaces.get(holder.uuid);
	}
}
