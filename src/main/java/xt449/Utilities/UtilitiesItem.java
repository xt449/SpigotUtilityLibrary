package xt449.Utilities;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class UtilitiesItem {
	
	public static final boolean isSimilar(ItemStack item, Material type, short data) {
		return item.isSimilar(new ItemStack(type, 0, data));
	}
	
	public static final boolean isSimilar(ItemStack item, Material type) {
		return item.isSimilar(new ItemStack(type));
	}
	
	public static final boolean isArmor(Material item) {
		return isHelmet(item) || isChestplate(item) || isLeggings(item) || isBoots(item);
	}
	
	public static final boolean isHelmet(Material item) {
		return Arrays.asList(Material.LEATHER_HELMET, Material.CHAINMAIL_HELMET, Material.GOLD_HELMET, Material.IRON_HELMET, Material.DIAMOND_HELMET).contains(item);
	}
	
	public static final boolean isChestplate(Material item) {
		return Arrays.asList(Material.LEATHER_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.GOLD_CHESTPLATE, Material.IRON_CHESTPLATE, Material.DIAMOND_CHESTPLATE).contains(item);
	}
	
	public static final boolean isLeggings(Material item) {
		return Arrays.asList(Material.LEATHER_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.GOLD_LEGGINGS, Material.IRON_LEGGINGS, Material.DIAMOND_LEGGINGS).contains(item);
	}
	
	public static final boolean isBoots(Material item) {
		return Arrays.asList(Material.LEATHER_BOOTS, Material.CHAINMAIL_BOOTS, Material.GOLD_BOOTS, Material.IRON_BOOTS, Material.DIAMOND_BOOTS).contains(item);
	}
	
	public static final boolean isTool(Material item) {
		return isFlintAndSteel(item) || isCompass(item) || isFishingRod(item) || isClock(item) || isShears(item) || isLead(item) || isNameTag(item) || isPickaxe(item) || isShovel(item) || isAxe(item) || isHoe(item);
	}
	
	public static final boolean isFlintAndSteel(Material item) {
		return Arrays.asList(Material.FLINT_AND_STEEL).contains(item);
	}
	
	public static final boolean isCompass(Material item) {
		return Arrays.asList(Material.COMPASS).contains(item);
	}
	
	public static final boolean isFishingRod(Material item) {
		return Arrays.asList(Material.FISHING_ROD).contains(item);
	}
	
	public static final boolean isClock(Material item) {
		return Arrays.asList(Material.WATCH).contains(item);
	}
	
	public static final boolean isShears(Material item) {
		return Arrays.asList(Material.SHEARS).contains(item);
	}
	
	public static final boolean isLead(Material item) {
		return Arrays.asList(Material.LEASH).contains(item);
	}
	
	public static final boolean isNameTag(Material item) {
		return Arrays.asList(Material.NAME_TAG).contains(item);
	}
	
	public static final boolean isPickaxe(Material item) {
		return Arrays.asList(Material.WOOD_PICKAXE, Material.STONE_PICKAXE, Material.GOLD_PICKAXE, Material.IRON_PICKAXE, Material.DIAMOND_PICKAXE).contains(item);
	}
	
	public static final boolean isShovel(Material item) {
		return Arrays.asList(Material.WOOD_SPADE, Material.STONE_SPADE, Material.GOLD_SPADE, Material.IRON_SPADE, Material.DIAMOND_SPADE).contains(item);
	}
	
	public static final boolean isAxe(Material item) {
		return Arrays.asList(Material.WOOD_AXE, Material.STONE_AXE, Material.GOLD_AXE, Material.IRON_AXE, Material.DIAMOND_AXE).contains(item);
	}
	
	public static final boolean isHoe(Material item) {
		return Arrays.asList(Material.WOOD_HOE, Material.STONE_HOE, Material.GOLD_HOE, Material.IRON_HOE, Material.DIAMOND_HOE).contains(item);
	}
	
	public static final boolean isWeapon(Material item) {
		return isBow(item) || isSword(item);
	}
	
	public static final boolean isBow(Material item) {
		return Arrays.asList(Material.BOW).contains(item);
	}
	
	public static final boolean isSword(Material item) {
		return Arrays.asList(Material.WOOD_SWORD, Material.STONE_SWORD, Material.GOLD_SWORD, Material.IRON_SWORD, Material.DIAMOND_SWORD).contains(item);
	}
}
