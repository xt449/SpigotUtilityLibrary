package xt449.bukkitutilitylibrary;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractEnchantment extends Enchantment {

	protected final String name;

	public AbstractEnchantment(@NotNull Plugin plugin, @NotNull String id) {
		super(new NamespacedKey(plugin, id));
		name = id;
	}

	@Override
	@Deprecated
	public @NotNull String getName() {
		return name;
	}
}
