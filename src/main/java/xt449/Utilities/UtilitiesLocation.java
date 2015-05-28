package xt449.Utilities;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class UtilitiesLocation {
	
	private String world;
	
	private double x;
	private double y;
	private double z;
	
	private float yaw;
	
	private float pitch;
	
	public UtilitiesLocation(String world, double x, double y, double z) {
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public UtilitiesLocation(String world, double x, double y, double z, float yaw, float pitch) {
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
	}
	
	public UtilitiesLocation(Location location) {
		world = location.getWorld().getName();
		x = location.getX();
		y = location.getY();
		z = location.getZ();
		yaw = location.getYaw();
		pitch = location.getPitch();
	}
	
	public final Location getLocation() {
		return new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
	}
	
	public final String getWorld() {
		return world;
	}
	
	public final double getX() {
		return x;
	}
	
	public final double getY() {
		return y;
	}
	
	public final double getZ() {
		return z;
	}
	
	public final float getYaw() {
		return yaw;
	}
	
	public final float getPitch() {
		return pitch;
	}
}
