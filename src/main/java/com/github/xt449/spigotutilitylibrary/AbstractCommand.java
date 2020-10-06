/*
 * Copyright (c) 2020 xt449/BinaryBanana
 *
 * This file is part of SpigotUtilityLibrary.
 *
 * SpigotUtilityLibrary is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SpigotUtilityLibrary is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SpigotUtilityLibrary.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.github.xt449.spigotutilitylibrary;

import org.bukkit.Bukkit;
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

/**
 * @author xt449
 */
public abstract class AbstractCommand extends Command implements PluginIdentifiableCommand {

	//private static final String MISSING_PERMISSION = ChatColor.RED + "You do not have permission to perform this command!";

	private static CommandMap commandMap;

	private final Plugin plugin;

	protected AbstractCommand(@NotNull Plugin plugin, @NotNull String name) {
		super(name);

		this.plugin = plugin;

		/*setAliases(getAliases());
		setDescription(getDescription());
		setPermission(getPermission());
		setPermissionMessage(AbstractCommand.MISSING_PERMISSION);
		setUsage(getUsage());*/
	}

	@Override
	public boolean execute(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) {
		//if(plugin.isEnabled()) {
		//if(hasPermission(sender)) {
		if(sender instanceof Player) {
			return onPlayerExecute((Player) sender, alias, args);
		} else {
			return onConsoleExecute(sender, alias, args);
		}
		//}
		//}

		//return false;
	}

	@NotNull
	@Override
	public List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) {
		//if(plugin.isEnabled()) {
		//if(hasPermission(sender)) {
		if(sender instanceof Player) {
			return onPlayerTab((Player) sender, alias, args);
		} else {
			return onConsoleTab(sender, alias, args);
		}
		//}
		//}

		//return Collections.emptyList();
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

	/*private boolean hasPermission(CommandSender sender) {
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
	}*/

	protected boolean onPlayerExecute(@NotNull Player sender, @NotNull String alias, @NotNull String[] args) {
		return onConsoleExecute(sender, alias, args);
	}

	protected boolean onConsoleExecute(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) {
		return false;
	}

	@NotNull
	protected List<String> onPlayerTab(@NotNull Player sender, @NotNull String alias, @NotNull String[] args) {
		return onConsoleTab(sender, alias, args);
	}

	@NotNull
	protected List<String> onConsoleTab(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) {
		return Collections.emptyList();
	}
}
