package xt449.bukkitutilitylibrary;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public final class TickTimeTimer {

	private static long lastTimeMillis = 0;
	private static long currentTimeMillis = 0;

	private static float smartTPS = 20;

	public static void startTimer(@NotNull final Plugin plugin) {
		lastTimeMillis = System.currentTimeMillis();

		Bukkit.getScheduler().runTaskTimer(plugin, () -> {
			lastTimeMillis = currentTimeMillis;
			currentTimeMillis = System.currentTimeMillis();

			final float temp = 1000F / (currentTimeMillis - lastTimeMillis); // one second
			smartTPS = (smartTPS + temp) / 2;
			/*tpsHistory.addFirst(temp);
			if(tpsHistory.size() > 20 * 60 * 15) { // fifteen minutes
				tpsHistory.removeLast();
			}*/
		}, 0, 1);
	}

	public static void startTimer(@NotNull final Plugin plugin, @NotNull final Consumer<Float> consumer) {
		lastTimeMillis = System.currentTimeMillis();

		Bukkit.getScheduler().runTaskTimer(plugin, () -> {
			lastTimeMillis = currentTimeMillis;
			currentTimeMillis = System.currentTimeMillis();

			final float temp = 1000F / (currentTimeMillis - lastTimeMillis); // one second
			consumer.accept(temp);
			smartTPS = (smartTPS + temp) / 2;
			/*tpsHistory.addFirst(temp);
			if(tpsHistory.size() > 20 * 60 * 15) { // fifteen minutes
				tpsHistory.removeLast();
			}*/
		}, 0, 1);
	}

	public static void startTimerSmarty(@NotNull final Plugin plugin, @NotNull final Consumer<Float> consumer) {
		lastTimeMillis = System.currentTimeMillis();

		Bukkit.getScheduler().runTaskTimer(plugin, () -> {
			lastTimeMillis = currentTimeMillis;
			currentTimeMillis = System.currentTimeMillis();

			final float temp = 1000F / (currentTimeMillis - lastTimeMillis); // one second
			smartTPS = (smartTPS + temp) / 2;
			consumer.accept(smartTPS);
			/*tpsHistory.addFirst(temp);
			if(tpsHistory.size() > 20 * 60 * 15) { // fifteen minutes
				tpsHistory.removeLast();
			}*/
		}, 0, 1);
	}

	/*public static final long getAverageTime() {
		return timeHistory.stream().mapToLong(value -> value).sum() / timeHistory.size();
	}*/

	public static float getSmartTPS() {
		return smartTPS;
	}

	/*private static final LinkedList<Float> tpsHistory = new LinkedList<>();*/

	/*public static float getTPS() {
		return tpsHistory.getFirst();
	}

	private static DoubleStream getTPSHistory() {
		return tpsHistory.stream().mapToDouble(value -> value);
	}

	public static double getTPSAverageWithLimit(int limit) {
		*//*if(limit >= tpsHistory.size()) {
			return getTPSAverage();
		}*//*
		return getTPSHistory().limit(limit).sum() / limit;
	}

	public static double getTPSAverage() {
		return tpsHistory.stream().mapToDouble(value -> value).sum() / tpsHistory.size();
	}*/
}
