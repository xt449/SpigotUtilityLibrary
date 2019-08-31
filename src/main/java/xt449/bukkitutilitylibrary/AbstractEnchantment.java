package xt449.bukkitutilitylibrary;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

@Deprecated
public abstract class AbstractEnchantment extends Enchantment {

	protected final String name;

	public AbstractEnchantment(@NotNull Plugin plugin, @NotNull String id) {
		super(new NamespacedKey(plugin, id));
		this.name = id;
	}

	public AbstractEnchantment(@NotNull Plugin plugin, @NotNull String id, @NotNull String name) {
		super(new NamespacedKey(plugin, id));
		this.name = name;
	}

	@Override
	public @NotNull String getName() {
		return name;
	}
}
