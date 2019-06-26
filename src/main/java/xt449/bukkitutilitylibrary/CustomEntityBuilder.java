package xt449.bukkitutilitylibrary;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;

/**
 * @author xt449
 * Copyright BinaryBanana/xt449 2019
 * All Rights Reserved
 */
public class CustomEntityBuilder<T extends Entity> {

	private final Class<T> entityType;
	private final NamespacedKey namespacedKey;
	private final String name;

	public CustomEntityBuilder(Class<T> entityType, NamespacedKey namespacedKey, String name) {
		this.entityType = entityType;
		this.namespacedKey = namespacedKey;
		this.name = name;
	}

	/*public T summon(World world, Location location) {
		location.setWorld(world);
		//new Location(world, location.getX(), location.getY(), location.getZ());

		world.spawn(location, entityType, entity -> {});
		return null;
	}

	static {


		Entity entity = new EntityZombie() {

		}
	}*/
}
