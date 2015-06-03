package xt449.Utilities;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class UtilitiesTitle {
	
	private PacketPlayOutTitle.EnumTitleAction action;
	private IChatBaseComponent text;
	private IChatBaseComponent title;
	private IChatBaseComponent subtitle;
	private int fadeIn;
	private int life;
	private int fadeOut;
	
	public UtilitiesTitle(IChatBaseComponent title, IChatBaseComponent subtitle, int fadeIn, int life, int fadeOut) {
		this.title = title;
		this.subtitle = subtitle;
		this.fadeIn = fadeIn;
		this.life = life;
		this.fadeOut = fadeOut;
	}
	
	public UtilitiesTitle(PacketPlayOutTitle.EnumTitleAction action, IChatBaseComponent text) {
		this.action = action;
		this.text = text;
	}
	
	public UtilitiesTitle(int fadeIn, int life, int fadeOut) {


		action = PacketPlayOutTitle.EnumTitleAction.TIMES;
		this.fadeIn = fadeIn;
		this.life = life;
		this.fadeOut = fadeOut;
	}
	
	public UtilitiesTitle(PacketPlayOutTitle.EnumTitleAction action) {
		this.action = action;
	}
	
	public final void sendPacket(Player... players) {
		int a = 0;
		
		if(action.equals(PacketPlayOutTitle.EnumTitleAction.CLEAR)) {
			a = 1;
		} else if(action.equals(PacketPlayOutTitle.EnumTitleAction.RESET)) {
			a = 2;
		} else if(action.equals(PacketPlayOutTitle.EnumTitleAction.SUBTITLE)) {
			a = 3;
		} else if(action.equals(PacketPlayOutTitle.EnumTitleAction.TIMES)) {
			a = 4;
		} else if(action.equals(PacketPlayOutTitle.EnumTitleAction.TITLE)) {
			a = 5;
		}
		
		for(Player player : players) {
			switch(a) {
				case 0: {
					((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.CLEAR, null));
					((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.RESET, null));
					((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutTitle(fadeIn, life, fadeOut));
					((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, title));
					((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subtitle));
					
					return;
				}
				case 1: {
					((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.CLEAR, null));
					
					return;
				}
				case 2: {
					((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.RESET, null));
					
					return;
				}
				case 3: {
					((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, text));
					
					return;
				}
				case 4: {
					((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutTitle(fadeIn, life, fadeOut));
					
					return;
				}
				case 5: {
					((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, text));
					
					return;
				}
			}
		}
	}
}
