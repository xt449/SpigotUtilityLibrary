package xt449.bukkitutilitylibrary.example;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xt449.bukkitutilitylibrary.AbstractCommand;

import java.util.ArrayList;
import java.util.List;

public final class ExampleCommand extends AbstractCommand {

	private final String permission_execute = "utlities.debug";

	private final Enchantment enchantment;

	ExampleCommand(ExamplePlugin plugin, Enchantment enchantment) {
		super(plugin, "debug");

		setPermission(permission_execute);

		this.enchantment = enchantment;
	}

	@Override
	protected final boolean onPlayerExecute(@NotNull Player sender, @NotNull String alias, @NotNull String[] args) {
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

	@Override
	protected final boolean onConsoleExecute(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) {
		return true;
	}

	@Override
	protected final List<String> onPlayerTab(@NotNull Player sender, @NotNull String alias, @NotNull String[] args) {
		return onConsoleTab(sender, alias, args);
	}

	@Override
	protected final List<String> onConsoleTab(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) {
		List<String> players = new ArrayList<>();

		for(OfflinePlayer player : Bukkit.getOfflinePlayers()) {
			players.add(player.getName());
		}

		return players;
	}
}
