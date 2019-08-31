package xt449.bukkitutilitylibrary;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

public abstract class AbstractCommand extends Command implements PluginIdentifiableCommand {

	private static final String MISSING_PERMISSION = ChatColor.RED + "You do not have permission to perform this command!";

	private static CommandMap commandMap;

	private Plugin plugin;

	protected AbstractCommand(Plugin plugin, String name) {
		super(name);

		this.plugin = plugin;

		setAliases(getAliases());
		setDescription(getDescription());
		setPermission(getPermission());
		setPermissionMessage(AbstractCommand.MISSING_PERMISSION);
		setUsage(getUsage());
	}

	@Override
	public final boolean execute(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) {
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

	@NotNull
	@Override
	public final List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) {
		if(plugin.isEnabled()) {
			if(hasPermission(sender)) {
				if(sender instanceof Player) {
					return onPlayerTab((Player) sender, alias, args);
				} else {
					return onConsoleTab(sender, alias, args);
				}
			}
		}

		return Collections.emptyList();
	}

	@NotNull
	@Override
	public final Plugin getPlugin() {
		return plugin;
	}

	public final void register() {
		if(AbstractCommand.commandMap == null) {
			try {
				Field cm = Bukkit.getServer().getClass().getDeclaredField("commandMap");

				cm.setAccessible(true);

				commandMap = (CommandMap) cm.get(Bukkit.getServer());
			} catch(RuntimeException | ReflectiveOperationException exc) {
				exc.printStackTrace();
			}
		}

		AbstractCommand.commandMap.register(plugin.getName(), this);
	}

	private boolean hasPermission(CommandSender sender) {
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

	protected abstract boolean onPlayerExecute(@NotNull Player sender, @NotNull String alias, @NotNull String[] args);

	protected abstract boolean onConsoleExecute(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args);

	protected abstract List<String> onPlayerTab(@NotNull Player sender, @NotNull String alias, @NotNull String[] args);

	protected abstract List<String> onConsoleTab(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args);
}
