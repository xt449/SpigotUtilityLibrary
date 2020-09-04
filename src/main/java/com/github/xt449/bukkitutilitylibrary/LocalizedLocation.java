package com.github.xt449.bukkitutilitylibrary;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.NumberConversions;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

/**
 * @author xt449
 */
@Deprecated
public class LocalizedLocation {

	private double x;
	private double y;
	private double z;

	private float yaw;
	private float pitch;

	/**
	 * Constructs a new LocalizedLocation with the given coordinates and direction
	 *
	 * @param x The x-coordinate of this new location
	 * @param y The y-coordinate of this new location
	 * @param z The z-coordinate of this new location
	 * @param yaw The absolute rotation on the x-plane, in degrees
	 * @param pitch The absolute rotation on the y-plane, in degrees
	 */
	public LocalizedLocation(double x, double y, double z, float yaw, float pitch) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
	}

	/**
	 * Constructs a new LocalizedLocation with the given coordinates
	 *
	 * @param x The x-coordinate of this new location
	 * @param y The y-coordinate of this new location
	 * @param z The z-coordinate of this new location
	 */
	public LocalizedLocation(double x, double y, double z) {
		this(x, y, z, 0, 0);
	}

	/**
	 * Creates a new Location using null world
	 *
	 * @return Location without specified world
	 */
	public Location toLocation() {
		return new Location(null, x, y, z, yaw, pitch);
	}

	/**
	 * Creates a new Location using the given world
	 *
	 * @param world World
	 * @return Location in given world
	 */
	public Location toLocation(World world) {
		return new Location(world, x, y, z, yaw, pitch);
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

	/**
	 * Sets the yaw of this location, measured in degrees.
	 * <ul>
	 * <li>A yaw of 0 or 360 represents the positive z direction.
	 * <li>A yaw of 180 represents the negative z direction.
	 * <li>A yaw of 90 represents the negative x direction.
	 * <li>A yaw of 270 represents the positive x direction.
	 * </ul>
	 * Increasing yaw values are the equivalent of turning to your
	 * right-facing, increasing the scale of the next respective axis, and
	 * decreasing the scale of the previous axis.
	 *
	 * @param yaw new rotation's yaw
	 */
	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	/**
	 * Gets the yaw of this location, measured in degrees.
	 * <ul>
	 * <li>A yaw of 0 or 360 represents the positive z direction.
	 * <li>A yaw of 180 represents the negative z direction.
	 * <li>A yaw of 90 represents the negative x direction.
	 * <li>A yaw of 270 represents the positive x direction.
	 * </ul>
	 * Increasing yaw values are the equivalent of turning to your
	 * right-facing, increasing the scale of the next respective axis, and
	 * decreasing the scale of the previous axis.
	 *
	 * @return the rotation's yaw
	 */
	public float getYaw() {
		return yaw;
	}

	/**
	 * Sets the pitch of this location, measured in degrees.
	 * <ul>
	 * <li>A pitch of 0 represents level forward facing.
	 * <li>A pitch of 90 represents downward facing, or negative y
	 *     direction.
	 * <li>A pitch of -90 represents upward facing, or positive y direction.
	 * </ul>
	 * Increasing pitch values the equivalent of looking down.
	 *
	 * @param pitch new incline's pitch
	 */
	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	/**
	 * Gets the pitch of this location, measured in degrees.
	 * <ul>
	 * <li>A pitch of 0 represents level forward facing.
	 * <li>A pitch of 90 represents downward facing, or negative y
	 *     direction.
	 * <li>A pitch of -90 represents upward facing, or positive y direction.
	 * </ul>
	 * Increasing pitch values the equivalent of looking down.
	 *
	 * @return the incline's pitch
	 */
	public float getPitch() {
		return pitch;
	}

	/**
	 * Gets a unit-vector pointing in the direction that this Location is
	 * facing.
	 *
	 * @return a vector pointing the direction of this location's {@link
	 *     #getPitch() pitch} and {@link #getYaw() yaw}
	 */
	@NotNull
	public Vector getDirection() {
		Vector vector = new Vector();

		double rotX = this.getYaw();
		double rotY = this.getPitch();

		vector.setY(-Math.sin(Math.toRadians(rotY)));

		double xz = Math.cos(Math.toRadians(rotY));

		vector.setX(-xz * Math.sin(Math.toRadians(rotX)));
		vector.setZ(xz * Math.cos(Math.toRadians(rotX)));

		return vector;
	}

	/**
	 * Sets the {@link #getYaw() yaw} and {@link #getPitch() pitch} to point
	 * in the direction of the vector.
	 *
	 * @param vector the direction vector
	 * @return the same location
	 */
	@NotNull
	public LocalizedLocation setDirection(@NotNull Vector vector) {
		/*
		 * Sin = Opp / Hyp
		 * Cos = Adj / Hyp
		 * Tan = Opp / Adj
		 *
		 * x = -Opp
		 * z = Adj
		 */
		final double _2PI = 2 * Math.PI;
		final double x = vector.getX();
		final double z = vector.getZ();

		if (x == 0 && z == 0) {
			pitch = vector.getY() > 0 ? -90 : 90;
			return this;
		}

		double theta = Math.atan2(-x, z);
		yaw = (float) Math.toDegrees((theta + _2PI) % _2PI);

		double x2 = NumberConversions.square(x);
		double z2 = NumberConversions.square(z);
		double xz = Math.sqrt(x2 + z2);
		pitch = (float) Math.toDegrees(Math.atan(-vector.getY() / xz));

		return this;
	}
}
