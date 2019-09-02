package xt449.bukkitutilitylibrary;

import org.bukkit.enchantments.Enchantment;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;

public class EnchantmentUtility {

	private static void prepareRegistration() {
		try {
			if(!Enchantment.isAcceptingRegistrations()) {
				final Field field = Enchantment.class.getDeclaredField("acceptingNew");

				field.setAccessible(true);
				field.set(null, true);
			}
		} catch(NoSuchFieldException | IllegalAccessException exc) {
			exc.printStackTrace();
		}
	}

	/**
	 * @param enchantment to be registered
	 * @return true if enchantment was registered successfully
	 * @throws IllegalArgumentException an enchantment with the same name or id already is registered.
	 */
	public static boolean registerEnchantment(@NotNull Enchantment enchantment) throws IllegalArgumentException {
		prepareRegistration();
		try {
			Enchantment.registerEnchantment(enchantment);
			return true;
		} catch(IllegalArgumentException ignored) {
			return false;
		}
	}
}
