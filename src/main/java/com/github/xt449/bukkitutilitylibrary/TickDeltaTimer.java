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
