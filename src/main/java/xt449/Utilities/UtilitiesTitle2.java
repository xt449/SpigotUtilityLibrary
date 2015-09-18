package xt449.Utilities;

import de.albionco.shop.utils.Jailbird;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class UtilitiesTitle2 {

	private String title;
	private String subtitle;
	private int fadeIn;
	private int life;
	private int fadeOut;

	public UtilitiesTitle2 setTitle(String title) {
		this.title = title;
		return this;
	}

	public UtilitiesTitle2 setSubtitle(String subtitle) {
		this.subtitle = subtitle;
		return this;
	}

	public UtilitiesTitle2 setTimes(int fadeIn, int life, int fadeOut) {
		this.fadeIn = fadeIn;
		this.life = life;
		this.fadeOut = fadeOut;
		return this;
	}

	public UtilitiesTitle2 clear(Player... players) {
		Class<?> titleClass = Jailbird.getNMSClass("PacketPlayOutTitle");
		Class<Enum<?>> titleActionClass = (Class<Enum<?>>) Jailbird.getNMSClass("PacketPlayOutTitle.EnumTitleAction");
		Class<?> chatBaseClass = Jailbird.getNMSClass("IChatBaseComponent");
		Class<?> chatBaseSerializerClass = Jailbird.getNMSClass("IChatBaseComponent.ChatSerializer");

		Object packet = null;

		try {
			packet = titleClass.getConstructor(titleActionClass, chatBaseClass).newInstance(titleActionClass.getEnumConstants()[0], chatBaseSerializerClass.getMethod("a", String.class).invoke(chatBaseSerializerClass, null));
		} catch(IllegalAccessException exc) {
			exc.printStackTrace();
		} catch(InstantiationException exc) {
			exc.printStackTrace();
		} catch(InvocationTargetException exc) {
			exc.printStackTrace();
		} catch(NoSuchMethodException exc) {
			exc.printStackTrace();
		} finally {
			for(Player player : players) {
				Object craftPlayer = Jailbird.getCraftBukkitClass("CraftPlayer").cast(player);

				try {
					Object playerHandle = craftPlayer.getClass().getMethod("getHandle").invoke(craftPlayer);

					Object playerConnection = playerHandle.getClass().getField("playerConnection").get(playerHandle);

					playerConnection.getClass().getMethod("sendPacket", Jailbird.getCraftBukkitClass("Packet")).invoke(playerConnection, packet);
				} catch(IllegalAccessException exc) {
					exc.printStackTrace();
				} catch(InvocationTargetException exc) {
					exc.printStackTrace();
				} catch(NoSuchFieldException exc) {
					exc.printStackTrace();
				} catch(NoSuchMethodException exc) {
					exc.printStackTrace();
				}
			}
		}

		return this;
	}

	public UtilitiesTitle2 reset(Player... players) {


		return this;
	}

	public UtilitiesTitle2 execute(Player... players) {


		return this;
	}
}
