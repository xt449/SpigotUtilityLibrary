package com.github.xt449.bukkitutilitylibrary.example;

import com.github.xt449.bukkitutilitylibrary.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * @author xt449
 */
public final class ExampleCommand extends AbstractCommand {

	private final Enchantment enchantment;

	ExampleCommand(@NotNull final ExamplePlugin plugin, @NotNull final Enchantment enchantment) {
		super(plugin, "debug");

		setPermission("utlities.debug");

		this.enchantment = enchantment;
	}

	@Override
	protected final boolean onPlayerExecute(@NotNull final Player sender, @NotNull final String alias, @NotNull final String[] args) {
		sender.sendMessage(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "]|[ ]|[ ]|[ SERVER DEBUG ]|[ ]|[ ]|[");
		sender.sendMessage(ChatColor.AQUA + "Server: " + ChatColor.WHITE + Bukkit.getServer().getName());
		sender.sendMessage(ChatColor.AQUA + "Version: " + ChatColor.WHITE + Bukkit.getName() + " " + Bukkit.getBukkitVersion());
		sender.sendMessage(ChatColor.AQUA + "Build: " + ChatColor.WHITE + Bukkit.getVersion());
		sender.sendMessage(ChatColor.AQUA + "Host: " + ChatColor.WHITE + Bukkit.getIp() + ":" + Bukkit.getPort());

		sender.sendMessage(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "]|[ ]|[ ]|[ PLAYER DEBUG ]|[ ]|[ ]|[");
		sender.sendMessage(ChatColor.AQUA + "Name: " + ChatColor.WHITE + sender.getName());
		sender.sendMessage(ChatColor.AQUA + "CustomName: " + ChatColor.WHITE + sender.getCustomName());
		sender.sendMessage(ChatColor.AQUA + "DisplayName: " + ChatColor.WHITE + sender.getDisplayName());
		sender.sendMessage(ChatColor.AQUA + "PlayerListName: " + ChatColor.WHITE + sender.getPlayerListName());
		sender.sendMessage(ChatColor.AQUA + "Address: " + ChatColor.WHITE + sender.getAddress().toString());
		sender.sendMessage(ChatColor.AQUA + "EntityID: " + ChatColor.WHITE + sender.getEntityId());
		sender.sendMessage(ChatColor.AQUA + "UniqueID: " + ChatColor.WHITE + sender.getUniqueId().toString());

		if(sender.isOp()) {
			sender.getInventory().getItemInMainHand().addUnsafeEnchantment(enchantment, 1);
		}

		return true;
	}
}
