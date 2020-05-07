package com.github.xt449.bukkitutilitylibrary;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

/**
 * @author xt449
 *
 * Calculates TPS from the length of time between ticks
 */
public final class TickTimeTimer {

	private static long lastTimeMillis = 0;
	private static long currentTimeMillis = 0;

	private static float smartTPS = 20;

	public static @NotNull BukkitTask startTimer(@NotNull final Plugin plugin) {
		lastTimeMillis = System.currentTimeMillis();

		return Bukkit.getScheduler().runTaskTimer(plugin, () -> {
			lastTimeMillis = currentTimeMillis;
			currentTimeMillis = System.currentTimeMillis();

			final float temp = 1000F / (currentTimeMillis - lastTimeMillis); // one second
			smartTPS = (smartTPS + temp) / 2;
		}, 0, 1);
	}

	public static float getSmartTPS() {
		return smartTPS;
	}
}
