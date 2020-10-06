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

public abstract class NMSHelper {

	private static String versionString;

	static {
		versionString = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		Bukkit.getLogger().info("NMS version is " + versionString);
	}

	public static String getVersionString() {
		if(versionString == null) {
			versionString = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
			Bukkit.getLogger().info("NMS version is " + versionString);
		}
		return versionString;
	}

	public static Class<?> getNMSClass(String className) throws ClassNotFoundException {
		return Class.forName("net.minecraft.server." + getVersionString() + '.' + className);
	}
}
