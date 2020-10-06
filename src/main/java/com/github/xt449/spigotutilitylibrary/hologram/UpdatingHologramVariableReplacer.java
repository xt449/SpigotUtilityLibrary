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

/**
 * @author xt449
 */
public class UpdatingHologramVariableReplacer {
	final String placeholder;
	final UpdatingHologramVariable variable;

	public UpdatingHologramVariableReplacer(String placeholder, UpdatingHologramVariable variable) {
		this.placeholder = placeholder;
		this.variable = variable;
	}

	String parse(String text, Hologram hologram) {
		return text.replace(placeholder, variable.getValue(hologram));
	}
}
