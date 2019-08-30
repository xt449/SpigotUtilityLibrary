package xt449.bukkitutilitylibrary;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.LinkedList;
import java.util.stream.DoubleStream;

@Deprecated
public final class TickTimerHybrid {

	private static long lastTimeMillis = 0;
	private static long currentTimeMillis = 0;
	private static int tickCounter = 0;

	private static float smartTPS = 20;

	private static final LinkedList<Float> tpsHistory = new LinkedList<>();

	/*private static final LinkedList<Long> timeHistory = new LinkedList<>();*/

	public static void beginMeasuringTicks(final Plugin plugin) {
		lastTimeMillis = System.currentTimeMillis();

		Bukkit.getScheduler().runTaskTimer(plugin, () -> {
			/*final long timer = System.nanoTime();*/
			//
			currentTimeMillis = System.currentTimeMillis();

			if(currentTimeMillis - lastTimeMillis > 1000) { // one second
				final float temp = ((1000F / (currentTimeMillis - lastTimeMillis)) + (tickCounter)) / 2;
				smartTPS = (smartTPS + temp) / 2;
				tpsHistory.addFirst(temp);
				if(tpsHistory.size() > 20 * 60 * 15) { // fifteen minutes
					tpsHistory.removeLast();
				}

				tickCounter = 0; // reset the FPS counter
				lastTimeMillis += 1000; // add one second
			}
			tickCounter++;

			//
			/*timeHistory.add(System.nanoTime() - timer);*/
			//Bukkit.broadcastMessage("Ticks: " + ());
		}, 0, 1);
	}

	/*public static final long getAverageTime() {
		return timeHistory.stream().mapToLong(value -> value).sum() / timeHistory.size();
	}*/

	public static float getSmartTPS() {
		return smartTPS;
	}

	public static float getTPS() {
		return tpsHistory.getFirst();
	}

	private static DoubleStream getTPSHistory() {
		return tpsHistory.stream().mapToDouble(value -> value);
	}

	public static double getTPSAverageWithLimit(int limit) {
		/*if(limit >= tpsHistory.size()) {
			return getTPSAverage();
		}*/
		return getTPSHistory().limit(limit).sum() / limit;
	}

	public static double getTPSAverage() {
		return tpsHistory.stream().mapToDouble(value -> value).sum() / tpsHistory.size();
	}
}
