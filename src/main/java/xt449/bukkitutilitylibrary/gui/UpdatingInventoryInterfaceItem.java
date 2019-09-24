package xt449.bukkitutilitylibrary.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @deprecated Updating soon
 */
@Deprecated
public class UpdatingInventoryInterfaceItem extends InventoryInterfaceItem {
	private final Updater updater;

	public UpdatingInventoryInterfaceItem(@NotNull ItemStack itemStack, @NotNull Action action, @NotNull Updater updater) {
		super(itemStack, action);
		this.updater = updater;
	}

	@Nullable
	final ItemStack triggerUpdate(@Nullable Player player, @Nullable ItemStack itemStack) {
		return this.updater.update(player, itemStack);
	}

	public interface Updater {
		/**
		 * @param player    The associated Player
		 * @param itemStack The associated ItemStack
		 */
		@Nullable
		ItemStack update(@Nullable Player player, @Nullable ItemStack itemStack);
	}
}
