package xt449.Utilities;

import java.lang.reflect.Field;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class UtilitiesEnchantment extends Enchantment {
	
	private String name;
	private int minLevel;
	private int maxLevel;
	private EnchantmentTarget target;
	
	public static final String EFFECT = "EFFECT";
	
	public UtilitiesEnchantment(String name, int minLevel, int maxLevel, EnchantmentTarget target) {
		super(UtilitiesEnchantment.getNextId());
		
		this.name = name;
		this.minLevel = minLevel;
		this.maxLevel = maxLevel;
		this.target = target;
	}
	
	public UtilitiesEnchantment(String name, int minLevel, int maxLevel) {
		this(name, minLevel, maxLevel, EnchantmentTarget.ALL);
	}
	
	public UtilitiesEnchantment(String name, EnchantmentTarget target) {
		this(name, 1, 10, target);
	}
	
	public UtilitiesEnchantment(String name) {
		this(name, 1, 10, EnchantmentTarget.ALL);
	}
	
	@SuppressWarnings("deprecation")
	private static final int getNextId() {
		int id = 0;
		
		while(Enchantment.getById(id) != null) {
			id++;
		}
		
		return id;
	}
	
	public static final Enchantment getEffectEnchantment() {
		return Enchantment.getByName(UtilitiesEnchantment.EFFECT);
	}
	
	protected final void register() {
		try {
			Field field = Enchantment.class.getDeclaredField("acceptingNew");
			
			field.setAccessible(true);
			field.set(null, true);
			
			try {
				Enchantment.registerEnchantment(this);
			}
			catch(IllegalArgumentException exc) {
				// ENCHANTMENT ALREADY REGISTERED!
				exc.printStackTrace();
			}
			
			field.set(null, false);
		}
		catch(IllegalAccessException exc) {
			exc.printStackTrace();
		}
		catch(IllegalArgumentException exc) {
			exc.printStackTrace();
		}
		catch(NoSuchFieldException exc) {
			exc.printStackTrace();
		}
		catch(SecurityException exc) {
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
		return name;
	}
	
	@Override
	public int getStartLevel() {
		return minLevel;
	}
	
	@Override
	public int getMaxLevel() {
		return maxLevel;
	}
	
	@Override
	public EnchantmentTarget getItemTarget() {
		return target;
	}
}
