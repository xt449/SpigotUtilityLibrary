package xt449.Utilities;

import net.minecraft.server.entity.Entity;
import net.minecraft.server.entity.EntityLiving;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Villager;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.lang.reflect.Field;

public class CustomEntity extends EntityLiving {

    public CustomEntity(World world) {
        super(((CraftWorld) world).getHandle());

        try {
            Field bField = PathfinderGoalSelector.class.getDeclaredField("b");
            bField.setAccessible(true);
            Field cField = PathfinderGoalSelector.class.getDeclaredField("c");
            cField.setAccessible(true);

            bField.set(goalSelector, new UnsafeList<PathfinderGoalSelector>());
            bField.set(targetSelector, new UnsafeList<PathfinderGoalSelector>());
            cField.set(goalSelector, new UnsafeList<PathfinderGoalSelector>());
            cField.set(targetSelector, new UnsafeList<PathfinderGoalSelector>());
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void move(double x, double y, double z) {
        // Unused ? Useless ?
        super.move(x, y, z);
    }

    @Override
    public void collide(Entity entity) {
        // Unused ? Useless ?
        super.collide(entity);
    }

    @Override
    public boolean damageEntity(DamageSource source, float damage) {
        // Unused ? Useless ?
        return super.damageEntity(source, damage);
    }

    @Override
    public void g(double x, double y, double z) {
        // Unused ? Useless ?
        super.g(x, y, z);
    }

    public static CustomEntity spawn(Location location){
        World world = ((CraftWorld) location.getWorld()).getHandle();
        final CustomEntity customEntity = new CustomEntity(world);

        customEntity.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        ((CraftLivingEntity) customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);
        world.addEntity(customEntity, CreatureSpawnEvent.SpawnReason.CUSTOM);
        return (LivingEntity) customEntity.getBukkitEntity();
    }
}
