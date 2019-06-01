package xt449.bukkitutilitylibrary;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Field;

public class UtilitiesEnchantment extends Enchantment {

	private static UtilitiesEnchantment instance;
	private static final String NAME = "Effect";

	private UtilitiesEnchantment(Plugin plugin) {
		super(new NamespacedKey(plugin, "effect"));
	}

	public static Enchantment getEnchantment() {
		return instance;
	}

	static void register(Plugin plugin) {
		try {
			if(!Enchantment.isAcceptingRegistrations()) {
				System.out.println("with reflection");
				final Field field = Enchantment.class.getDeclaredField("acceptingNew");

				field.setAccessible(true);
				field.set(null, true);
			} else {
				System.out.println("without reflection");
			}

			//try {
			instance = new UtilitiesEnchantment(plugin);
			Enchantment.registerEnchantment(instance);
			//} catch(IllegalArgumentException exc) {
			// ENCHANTMENT ALREADY REGISTERED!
			//}

			Bukkit.getLogger().info("[Utilities] Enchantment registered successfully");

			//field.set(null, false);
		} catch(IllegalAccessException | NoSuchFieldException exc) {
			exc.printStackTrace();
		}
	}

	@Override
	public boolean canEnchantItem(ItemStack item) {
		return true;
	}

	@Override
	public boolean conflictsWith(Enchantment other) {
		return other.equals(this);
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public int getStartLevel() {
		return 0;
	}

	@Override
	public int getMaxLevel() {
		return 0;
	}

	@Override
	public EnchantmentTarget getItemTarget() {
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
