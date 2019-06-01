package xt449.bukkitutilitylibrary;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Field;
import java.util.List;

public abstract class UtilitiesCommand extends Command implements PluginIdentifiableCommand {

	public static final String MISSING_PERMISSION = ChatColor.RED + "You do not have permission to perform this command!";

	private static CommandMap commandMap;

	private Plugin plugin;

	protected UtilitiesCommand(Plugin plugin, String name) {
		super(name);

		this.plugin = plugin;

		setAliases(getAliases());
		setDescription(getDescription());
		setPermission(getPermission());
		setPermissionMessage(UtilitiesCommand.MISSING_PERMISSION);
		setUsage(getUsage());
	}

	@Override
	public final boolean execute(CommandSender sender, String alias, String[] args) {
		if(plugin.isEnabled()) {
			if(hasPermission(sender)) {
				if(sender instanceof Player) {
					return onPlayerExecute((Player) sender, alias, args);
				} else {
					return onConsoleExecute(sender, alias, args);
				}
			}
		}

		return false;
	}

	@Override
	public final List<String> tabComplete(CommandSender sender, String alias, String[] args) {
		if(plugin.isEnabled()) {
			if(hasPermission(sender)) {
				if(sender instanceof Player) {
					return onPlayerTab((Player) sender, alias, args);
				} else {
					return onConsoleTab(sender, alias, args);
				}
			}
		}

		return null;
	}

	public final Plugin getPlugin() {
		return plugin;
	}

	public final void register() {
		if(UtilitiesCommand.commandMap == null) {
			try {
				Field cm = Bukkit.getServer().getClass().getDeclaredField("commandMap");

				cm.setAccessible(true);

				commandMap = (CommandMap) cm.get(Bukkit.getServer());
			} catch(RuntimeException exc) {
				exc.printStackTrace();
			} catch(ReflectiveOperationException exc) {
				exc.printStackTrace();
			}
		}

		UtilitiesCommand.commandMap.register(plugin.getName(), this);
	}

	private final boolean hasPermission(CommandSender sender) {
		if(getPermission() != null) {
			if(sender.hasPermission(getPermission())) {
				return true;
			} else {
				if(!getPermissionMessage().isEmpty()) {
					sender.sendMessage(getPermissionMessage());
				}

				return false;
			}
		}

		return true;
	}

	protected abstract boolean onPlayerExecute(Player sender, String alias, String[] args);

	protected abstract boolean onConsoleExecute(CommandSender sender, String alias, String[] args);

	protected abstract List<String> onPlayerTab(Player sender, String alias, String[] args);

	protected abstract List<String> onConsoleTab(CommandSender sender, String alias, String[] args);
}
