/*
 * Copyright (c) 2020 xt449/BinaryBanana
 *
 * This file is part of BukkitUtilityLibrary.
 *
 * BukkitUtilityLibrary is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BukkitUtilityLibrary is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with BukkitUtilityLibrary.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package com.github.xt449.bukkitutilitylibrary;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

/**
 * @author xt449
 *
 * Calculates TPS from the number of ticks between seconds
 */
public final class TickDeltaTimer {

	private static long lastTimeMillis = 0;
	private static int tickCounter = 0;

	private static float smartTPS = 20;

	public static @NotNull BukkitTask startTimer(@NotNull final Plugin plugin) {
		lastTimeMillis = System.currentTimeMillis();

		return Bukkit.getScheduler().runTaskTimer(plugin, () -> {
			final long difference = System.currentTimeMillis() - lastTimeMillis;
			if(difference >= 1000) { // one second
				smartTPS = (smartTPS + tickCounter) / 2;

				tickCounter = 0; // reset the counter
				lastTimeMillis += difference; // add one second
			}
			tickCounter++;
		}, 0, 1);
	}

	public static float getSmartTPS() {
		return smartTPS;
	}
}
