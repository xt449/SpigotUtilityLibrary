package xt449.bukkitutilitylibrary;

import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.awt.Color;

public class Test implements Listener {

	public Test(final Plugin plugin) {
		//init
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin,
				new Runnable() {
					private int deg = 0;

					public final void run() {
						for(World world : Bukkit.getWorlds()) {
							for(final ArmorStand stand : world.getEntitiesByClass(ArmorStand.class)) {
								if(stand.getName().equals("EndRod")) {
									world.spawnParticle(Particle.END_ROD,
											stand.getLocation().getX() + Math.sin(Math.toRadians(deg)),
											stand.getLocation().getY() + 1.0 + (Math.sin(Math.toRadians(deg * 3)) / 2),
											stand.getLocation().getZ() + Math.cos(Math.toRadians(deg)),
											1, 0, 0, 0, 0)
									;
									world.spawnParticle(Particle.END_ROD,
											stand.getLocation().getX() + Math.sin(Math.toRadians(deg - 120)),
											stand.getLocation().getY() + 1.0 + (Math.sin(Math.toRadians((deg - 120) * 3)) / 2),
											stand.getLocation().getZ() + Math.cos(Math.toRadians(deg - 120)),
											1, 0, 0, 0, 0)
									;
									world.spawnParticle(Particle.END_ROD,
											stand.getLocation().add(Math.sin(Math.toRadians(deg - 240)), 1.0 + (Math.sin(Math.toRadians((deg - 240) * 3)) / 2), Math.cos(Math.toRadians(deg - 240))), 1, 0, 0, 0, 0);
								}
							}
						}

						// TODO : 360 / 5 = 72
						if((deg += 5) == 360) {
							deg = 0;
						}
					}
				},
				120, 1
		);

		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin,
				new Runnable() {
					private int deg = 0;

					//private Color color = java.awt.Color.RED;
					//private Color color = new Color(255, 0, 0);
					private Color color = Color.getHSBColor(0, 1, 1);

					public final void run() {
						for(World world : Bukkit.getWorlds()) {
							for(final ArmorStand stand : world.getEntitiesByClass(ArmorStand.class)) {
								if(stand.getName().equals("Rainbow")) {
									world.spawnParticle(
											Particle.REDSTONE,
											stand.getLocation().add(Math.sin(Math.toRadians(deg)), 1, Math.cos(Math.toRadians(deg))),
											0,
											((float) color.getRed()) / 255 - 1,
											((float) color.getGreen()) / 255,
											((float) color.getBlue()) / 255,
											1
									);
								}
							}
						}

						// TODO : Color interval
						color = Color.getHSBColor(Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null)[0] + 0.01F, 1, 1);

						// TODO : Degree interval : 360 / 10 = 36
						if((deg += 10) == 360) {
							deg = 0;
						}
					}
				},
				120, 1
		);

		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin,
				new Runnable() {
					private int deg = 0;

					@SuppressWarnings("ALL") // TODO : IDE Bug
					public final void run() {
						for(World world : Bukkit.getWorlds()) {
							for(final ArmorStand stand : world.getEntitiesByClass(ArmorStand.class)) {
								Particle particle = null;

								try {
									particle = Particle.valueOf(stand.getName().toUpperCase());
								} catch(IllegalArgumentException exc) {
									// TODO : DO NOT PRINT STACK TRACE - exc.printStackTrace();
									continue;
								}
							/*finally {
								if(particle != null) {
									world.spawnParticle(particle, stand.getLocation().add(Math.sin(Math.toRadians(deg)), 1, Math.cos(Math.toRadians(deg))), 1, 0, 0, 0, 0);
								}
							}
							*/

								if(particle != null) {
									world.spawnParticle(particle, stand.getLocation().add(Math.sin(Math.toRadians(deg)), 1, Math.cos(Math.toRadians(deg))), 1, 0, 0, 0, 0);
								}
							}
						}

						// TODO : 360 / 1 = 360
						if((deg += 1) == 360) {
							deg = 0;
						}
					}
				},
				20, 2
		);

		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin,
				new Runnable() {
					private int deg = 0;

					private Color color = Color.getHSBColor(0, 1, 1);

					public final void run() {
						for(Player player : Bukkit.getOnlinePlayers()) {
							player.spawnParticle(
									Particle.SPELL_MOB,
									player.getLocation().add(0, 2, 0),
									0,
									((float) color.getRed()) / 255,
									((float) color.getGreen()) / 255,
									((float) color.getBlue()) / 255,
									1
							);
						}

						// TODO : Color interval
						color = Color.getHSBColor(Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null)[0] + 0.01F, 1, 1);

						// TODO : Degree interval : 360 / 3 = 120
						if((deg += 3) == 360) {
							deg = 0;
						}
					}
				},
				0, 0
		);
	}
}
