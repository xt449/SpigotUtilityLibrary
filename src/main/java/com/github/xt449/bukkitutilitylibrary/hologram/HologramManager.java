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

package com.github.xt449.bukkitutilitylibrary.hologram;

import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt449
 */
public class HologramManager {

	private static List<Hologram> holograms = new ArrayList<>();
	private static boolean initialized = false;

	public static void initialize(Plugin plugin) {
		if(!initialized) {
			/*ProtocolManager protocol = ProtocolLibrary.getProtocolManager();

			protocol.addPacketListener(new PacketAdapter(plugin, ListenerPriority.HIGHEST, PacketType.Play.Server.SPAWN_ENTITY) {
				@Override
				public final void onPacketSending(PacketEvent event) {
					*//*System.out.println(":: " + event.getPacketType() + " ::");*//*

					if(event.getPacket().getIntegers().read(0) == EntityObjectTypes.ArmorStand) {
						final ChunkPosition position = new ChunkPosition((int) (event.getPacket().getDoubles().read(0) / 16), (int) (event.getPacket().getDoubles().read(1) / 16)).normalized();
						if(MinecraftCivilization.getPlayerNation(event.getPlayer()).hasVisionAt(position)) {
							event.setCancelled(true);
						}
					}

					*//*for(Object object : event.getPacket().getModifier().getValues()) {
						if(object != null) {
							if(object instanceof Collection) {
								System.out.println("> Array List {");
								//Collection list = ;
								for(Object element : (Collection) object) {
									if(element instanceof DataWatcher.Item) {
										final DataWatcher.Item<?> item = (DataWatcher.Item<?>) element;
										// a() - getWatcherObject
										// a(Object) - setValue
										// a(boolean) - setFlag ?
										// b() - getValue
										// c() - getFlag ?
										// d() - clone
										System.out.println("> [" + item.a().a() + "] > " + item.b().getClass() + " = " + item.b().toString());
									} else {
										System.out.println("> [*] > " + element.getClass() + " = " + element.toString());
									}
								}
								System.out.println("> }");
							} else {
								System.out.println("> " + object.getClass() + " = " + object.toString());
							}
						} else {
							System.out.println("> null");
						}
					}*//*
				}
			});*/

			initialized = true;
		}
	}

	static Hologram register(Hologram hologram) {
		if(!initialized) {
			throw new IllegalMonitorStateException("HologramManager was not initialized by any plugin!");
		} else {
			holograms.add(hologram);
			return hologram;
		}
	}

	void update() {
		for(Hologram hologram : holograms) {
			hologram.update();
		}
	}
}
