package xt449.bukkitutilitylibrary;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public final class TickDeltaTimer {

	private static long lastTimeMillis = 0;
	private static int tickCounter = 0;

	private static float smartTPS = 20;

	public static void startTimer(@NotNull final Plugin plugin) {
		lastTimeMillis = System.currentTimeMillis();

		Bukkit.getScheduler().runTaskTimer(plugin, () -> {
			if(System.currentTimeMillis() - lastTimeMillis > 1000) { // one second
				smartTPS = (smartTPS + tickCounter) / 2;
				/*tpsHistory.addFirst(tickCounter);
				if(tpsHistory.size() > 20 * 60 * 15) { // fifteen minutes
					tpsHistory.removeLast();
				}*/

				tickCounter = 0; // reset the counter
				lastTimeMillis += 1000; // add one second
			}
			tickCounter++;
		}, 0, 1);
	}

	public static void startTimer(@NotNull final Plugin plugin, @NotNull final Consumer<Integer> consumer, final boolean updateOnly) {
		lastTimeMillis = System.currentTimeMillis();

		if(updateOnly) {
			Bukkit.getScheduler().runTaskTimer(plugin, () -> {
				if(System.currentTimeMillis() - lastTimeMillis > 1000) { // one second
					consumer.accept(tickCounter);
					smartTPS = (smartTPS + tickCounter) / 2;
					/*tpsHistory.addFirst(tickCounter);
					if(tpsHistory.size() > 20 * 60 * 15) { // fifteen minutes
						tpsHistory.removeLast();
					}*/

					tickCounter = 0; // reset the counter
					lastTimeMillis += 1000; // add one second
				}
				tickCounter++;
			}, 0, 1);
		} else {
			AtomicInteger tps = new AtomicInteger(-1);

			Bukkit.getScheduler().runTaskTimer(plugin, () -> {
				if(System.currentTimeMillis() - lastTimeMillis > 1000) { // one second
					tps.set(tickCounter);
					smartTPS = (smartTPS + tickCounter) / 2;
					/*tpsHistory.addFirst(tickCounter);
					if(tpsHistory.size() > 20 * 60 * 15) { // fifteen minutes
						tpsHistory.removeLast();
					}*/

					tickCounter = 0; // reset the counter
					lastTimeMillis += 1000; // add one second
				}
				consumer.accept(tps.get());
				tickCounter++;
			}, 0, 1);
		}
	}

	public static void startTimerSmartly(@NotNull final Plugin plugin, @NotNull final Consumer<Float> consumer, final boolean updateOnly) {
		lastTimeMillis = System.currentTimeMillis();

		if(updateOnly) {
			Bukkit.getScheduler().runTaskTimer(plugin, () -> {
				if(System.currentTimeMillis() - lastTimeMillis > 1000) { // one second
					smartTPS = (smartTPS + tickCounter) / 2;
					consumer.accept(smartTPS);
					/*tpsHistory.addFirst(tickCounter);
					if(tpsHistory.size() > 20 * 60 * 15) { // fifteen minutes
						tpsHistory.removeLast();
					}*/

					tickCounter = 0; // reset the counter
					lastTimeMillis += 1000; // add one second
				}
				tickCounter++;
			}, 0, 1);
		} else {
			Bukkit.getScheduler().runTaskTimer(plugin, () -> {
				if(System.currentTimeMillis() - lastTimeMillis > 1000) { // one second
					smartTPS = (smartTPS + tickCounter) / 2;
					/*tpsHistory.addFirst(tickCounter);
					if(tpsHistory.size() > 20 * 60 * 15) { // fifteen minutes
						tpsHistory.removeLast();
					}*/

					tickCounter = 0; // reset the counter
					lastTimeMillis += 1000; // add one second
				}
				consumer.accept(smartTPS);
				tickCounter++;
			}, 0, 1);
		}
	}

	public static float getSmartTPS() {
		return smartTPS;
	}

	/*private static final LinkedList<Integer> tpsHistory = new LinkedList<>();*/

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
