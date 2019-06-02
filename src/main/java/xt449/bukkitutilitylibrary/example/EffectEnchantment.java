package xt449.bukkitutilitylibrary.example;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class EffectEnchantment extends Enchantment {

	EffectEnchantment(Plugin plugin) {
		super(new NamespacedKey(plugin, "effect"));
	}

	@Override
	public boolean canEnchantItem(@NotNull ItemStack item) {
		return true;
	}

	@Override
	public boolean conflictsWith(Enchantment other) {
		return other.equals(this);
	}

	@Override
	public @NotNull String getName() {
		return "Example Effect";
	}

	@Override
	public int getStartLevel() {
		return 1;
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public @NotNull EnchantmentTarget getItemTarget() {
		return EnchantmentTarget.ALL;
	}

	@Override
	public boolean isCursed() {
		return false;
	}

	@Override
	public boolean isTreasure() {
		return false;
	}
}
