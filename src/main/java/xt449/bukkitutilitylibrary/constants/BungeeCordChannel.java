package xt449.bukkitutilitylibrary.constants;

public final class BungeeCordChannel {

	/**
	 * BungeeCord channel for plugin messaging
	 */
	public static final String CHANNEL = "BungeeCord";

	/**
	 * Connects the player to a server
	 *
	 * @param String - name of server (as defined in BungeeCord config.yml)
	 */
	public static final String CONNECT = "Connect";

	/**
	 * Connects a player to a server
	 *
	 * @param String - name of player
	 * @param String - name of server (as defined in BungeeCord config.yml)
	 */
	public static final String CONNECTOTHER = "ConnectOther";

	/**
	 * Gets the IP of the player
	 */
	public static final String IP = "IP";

	/**
	 * Gets the amount of players on a server |OR| ALL the servers
	 *
	 * @param String - name of server (as defined in BungeeCord config.yml) |OR| ALL (for global count)
	 */
	public static final String PLAYERCOUNT = "PlayerCount";

	/**
	 * Gets the list of players on a server |OR| ALL the servers
	 *
	 * @param String - name of server (as defined in BungeeCord config.yml) |OR| ALL (for global count)
	 */
	public static final String PLAYERLIST = "PlayerList";

	/**
	 * Gets the list of server names (as defined in BungeeCord config.yml)
	 */
	public static final String GETSERVERS = "GetServers";

	/**
	 * Sends a message to a player
	 *
	 * @param String - name of player
	 * @param String - message to send
	 */
	public static final String MESSAGE = "Message";

	/**
	 * Gets the name of the server to which the player is connected
	 */
	public static final String GETSERVER = "GetServer";

	/**
	 * Send a plugin message to a server |OR| ALL the servers
	 *
	 * @param String - name of server (as defined in BungeeCord config.yml) |OR| ALL (for global count)
	 * @param String - subchannel
	 * @param Short - size of message
	 * @param Byte[] - message
	 */
	public static final String FORWARD = "Forward";

	/**
	 * Gets the UUID of the player
	 */
	public static final String UUID = "UUID";

	/**
	 * Gets the UUID of a player
	 *
	 * @param String - name of player
	 */
	public static final String UUIDOTHER = "UUIDOther";

	/**
	 * Gets the IP of a server
	 *
	 * @param String - name of server
	 */
	public static final String SERVERIP = "ServerIP";
}
