package com.github.xt449.bukkitutilitylibrary;

import org.bukkit.Location;
import org.bukkit.World;

/**
 * @author xt449
 */
public class LocalizedLocation {

	private double x;
	private double y;
	private double z;

	/**
	 * Constructs a new LocalizedLocation with the given coordinates
	 *
	 * @param x The x-coordinate of this new location
	 * @param y The y-coordinate of this new location
	 * @param z The z-coordinate of this new location
	 */
	public LocalizedLocation(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Creates a new Location using null world
	 *
	 * @return Location without specified world
	 */
	public Location toLocation() {
		return new Location(null, x, y, z);
	}

	/**
	 * Creates a new Location using the given world
	 *
	 * @param world World
	 * @return Location in given world
	 */
	public Location toLocation(World world) {
		return new Location(world, x, y, z);
	}

	/**
	 * Sets the x-coordinate of this location
	 *
	 * @param x X-coordinate
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Gets the x-coordinate of this location
	 *
	 * @return x-coordinate
	 */
	public double getX() {
		return x;
	}

	/**
	 * Sets the y-coordinate of this location
	 *
	 * @param y y-coordinate
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Gets the y-coordinate of this location
	 *
	 * @return y-coordinate
	 */
	public double getY() {
		return y;
	}

	/**
	 * Sets the z-coordinate of this location
	 *
	 * @param z z-coordinate
	 */
	public void setZ(double z) {
		this.z = z;
	}

	/**
	 * Gets the z-coordinate of this location
	 *
	 * @return z-coordinate
	 */
	public double getZ() {
		return z;
	}
}
