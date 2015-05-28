package xt449.Utilities.Command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import xt449.Utilities.UtilitiesCommand;
import xt449.Utilities.UtilitiesEnchantment;

public class DebugCommand extends UtilitiesCommand {
	
	private final String permission_execute = "utlities.debug";
	
	public DebugCommand(Plugin plugin) {
		super(plugin, "debug");
		
		setPermission(permission_execute);
	}
	
	@Override
	protected final boolean onPlayerExecute(Player sender, String alias, String[] args) {
		sender.sendMessage(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "]|[ ]|[ ]|[ SERVER DEBUG ]|[ ]|[ ]|[");
		sender.sendMessage(ChatColor.AQUA + "Server: " + ChatColor.WHITE + Bukkit.getServerName() + " (" + Bukkit.getServerId() + ")");
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
			sender.getItemInHand().addUnsafeEnchantment(UtilitiesEnchantment.getEffectEnchantment(), 1);
		}
		
		return true;
	}
	
	@Override
	protected final boolean onConsoleExecute(CommandSender sender, String alias, String[] args) {
		return true;
	}
	
	@Override
	protected final List<String> onPlayerTab(Player sender, String alias, String[] args) {
		return onConsoleTab(sender, alias, args);
	}
	
	@Override
	protected final List<String> onConsoleTab(CommandSender sender, String alias, String[] args) {
		List<String> players = new ArrayList<String>();
		
		for(OfflinePlayer player : Bukkit.getOfflinePlayers()) {
			players.add(player.getName());
		}
		
		return players;
	}
}
