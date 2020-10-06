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

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SimplePlaceholder {

	private final String placeholder;

	private String value = null;

	public SimplePlaceholder(@NotNull String placeholder, String value) {
		this.placeholder = placeholder;
		this.value = value;
	}

	public SimplePlaceholder(@NotNull String placeholder) {
		this.placeholder = placeholder;
	}

	@NotNull
	public String getPlaceholder() {
		return placeholder;
	}

	@Nullable
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
