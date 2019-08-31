package xt449.bukkitutilitylibrary.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class UpdatingInventoryInterfaceItem extends InventoryInterfaceItem {
	private final Updater updater;

	public UpdatingInventoryInterfaceItem(ItemStack itemStack, Action action, Updater updater) {
		super(itemStack, action);
		this.updater = updater;
	}

	final ItemStack triggerUpdate(@Nullable Player player, @Nullable ItemStack itemStack) {
		return this.updater.update(player, itemStack);
	}

	public interface Updater {
		/**
		 * @param player    The associated Player
		 * @param itemStack The associated ItemStack
		 */
		ItemStack update(@Nullable Player player, @Nullable ItemStack itemStack);
	}
}
