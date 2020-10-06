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

package com.github.xt449.spigotutilitylibrary.hologram;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xt449
 */
public class HologramBuilder {

	private List<String> rawTexts = new ArrayList<>();
	private List<UpdatingHologramVariableReplacer> replacers = new ArrayList<>();
	//private boolean defaultVisibility = false;
	//private List<Player> playerList = new ArrayList<>();

	public HologramBuilder(String rawTexts) {
		this.rawTexts.addAll(Arrays.asList(rawTexts.split("\n")));
		/*for(String rawText : rawTexts.split("\n")) {
			this.rawTexts.add(rawText);
		}*/
	}

	public HologramBuilder(List<String> rawTexts) {
		this.rawTexts = rawTexts;
	}

	public HologramBuilder setRawTexts(List<String> rawTexts) {
		this.rawTexts = rawTexts;

		return this;
	}

	public HologramBuilder addText(String text) {
		this.rawTexts.add(text);

		return this;
	}

	public HologramBuilder setReplacers(List<UpdatingHologramVariableReplacer> replacers) {
		this.replacers = replacers;

		return this;
	}

	public HologramBuilder addReplacer(UpdatingHologramVariableReplacer replacer) {
		this.replacers.add(replacer);

		return this;
	}

	/*public HologramBuilder setDefaultVisibility(boolean defaultVisibility) {
		this.defaultVisibility = defaultVisibility;

		return this;
	}

	public HologramBuilder setPlayerList(List<Player> playerList) {
		this.playerList = playerList;

		return this;
	}

	public HologramBuilder addPlayer(Player player) {
		this.playerList.add(player);

		return this;
	}*/

	/*public Hologram build(World world, int x, int y, int z) {
		return build(new Location(world, x, y, z));
	}*/

	public Hologram build(Location location) {
		return HologramManager.register(new Hologram(location, rawTexts, replacers/*, defaultVisibility, playerList*/));
	}
}
