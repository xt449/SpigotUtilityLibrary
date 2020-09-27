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

package com.github.xt449.bukkitutilitylibrary.scoreboard;

import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Objective;

/**
 * @author xt449
 */
public abstract class ScoreHelper {

	@Deprecated
	public static void getScore(OfflinePlayer player, Objective objective) {
		objective.getScore(player).getScore();
	}

	@Deprecated
	public static void setScore(OfflinePlayer player, Objective objective, int value) {
		objective.getScore(player).setScore(value);
	}

	public static void getScore(String entryName, Objective objective) {
		objective.getScore(entryName).getScore();
	}

	public static void setScore(String entryName, Objective objective, int value) {
		objective.getScore(entryName).setScore(value);
	}
}
