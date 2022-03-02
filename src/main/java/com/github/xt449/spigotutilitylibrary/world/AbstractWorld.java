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

package com.github.xt449.spigotutilitylibrary.world;

import org.bukkit.*;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author xt449
 */
public abstract class AbstractWorld {

	public final String name;
	World world;

	protected GameMode defaultGameMode = null;

	private boolean loaded = false;

	AbstractWorld(String name, World world) {
		this.name = name;
		this.world = world;
		loaded = world.getLoadedChunks().length > 0;
	}

	AbstractWorld(String name) {
		this.name = name;
		this.world = Bukkit.createWorld(new WorldCreator(name));
		loaded = true;
	}

	AbstractWorld(String name, WorldCreator worldCreator) {
		this.name = name;
		this.world = Bukkit.createWorld(new WorldCreator(name).copy(worldCreator));
		loaded = true;
	}

	public World getWorld() {
		return world;
	}

	private final Map<UUID, Location> lastLocations = new HashMap<>();

	public void join(Player player) {
		join(player, world.getSpawnLocation());
	}

	public void join(Player player, Location location) {
		player.teleport(new Location(world, location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch()));
		if(defaultGameMode != null) {
			player.setGameMode(defaultGameMode);
		}
	}

	public void kick(Player player) {
		final Location lastLocation = lastLocations.get(player.getUniqueId());
		if(lastLocation != null) {
			player.teleport(lastLocation);
		} else {
			Bukkit.getLogger().fine("Unable to kick player (" + player.getName() + ") to previous world. Sent to primary server world");
			player.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
		}
	}

	boolean isLoaded() {
		return loaded;
	}

	void load() {
		if(!loaded) {
			world = Bukkit.createWorld(new WorldCreator(name).copy(world));
		}
	}

	void unload() {
		if(loaded) {
			// kick all players
			world.getPlayers().forEach(this::kick);
			// delay because otherwise stuff breaks
			Executors.newScheduledThreadPool(1).schedule(() -> {
				// Unload world from Bukkit
				if(!Bukkit.unloadWorld(world, false)) {
					Bukkit.getLogger().fine("Unable to unload (" + getClass().getSimpleName() + ") " + name + "! Now trying again...");
					Bukkit.unloadWorld(world, true);
				}
				// Delete world folder
				try {
					// TODO
					Files.walk(new File(Bukkit.getWorldContainer(), name).toPath()).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
					Bukkit.getLogger().finest("Successfully unloaded (" + getClass().getSimpleName() + ") " + name);
				} catch(IOException exc) {
					Bukkit.getLogger().warning("Failed to unload (" + getClass().getSimpleName() + ") " + name);
					exc.printStackTrace();
				}
			}, 100, TimeUnit.NANOSECONDS); // ~10TPS speed
		}
	}
}
