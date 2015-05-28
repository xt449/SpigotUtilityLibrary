package xt449.Utilities.Channel;

public class BungeeCordChannel {
	
	/**
	 * BungeeCord channel for plugin messaging
	 */
	public static final String channel = "BungeeCord";
	
	/**
	 * Connects the player to a server
	 * 
	 * @param String
	 *            - name of server (as defined in BungeeCord config.yml)
	 */
	public static final String Connect = "BungeeCord";
	
	/**
	 * Connects a player to a server
	 * 
	 * @param String
	 *            - name of player
	 * @param String
	 *            - name of server (as defined in BungeeCord config.yml)
	 */
	public static final String ConnectOther = "BungeeCord";
	
	/**
	 * Gets the IP of the player
	 */
	public static final String IP = "BungeeCord";
	
	/**
	 * Gets the amount of players on a server |OR| ALL the servers
	 * 
	 * @param String
	 *            - name of server (as defined in BungeeCord config.yml) |OR|
	 *            ALL (for global count)
	 */
	public static final String PlayerCount = "BungeeCord";
	
	/**
	 * Gets the list of players on a server |OR| ALL the servers
	 * 
	 * @param String
	 *            - name of server (as defined in BungeeCord config.yml) |OR|
	 *            ALL (for global count)
	 */
	public static final String PlayerList = "BungeeCord";
	
	/**
	 * Gets the list of server names (as defined in BungeeCord config.yml)
	 */
	public static final String GetServers = "BungeeCord";
	
	/**
	 * Sends a message to a player
	 * 
	 * @param String
	 *            - name of player
	 * @param String
	 *            - message to send
	 */
	public static final String Message = "BungeeCord";
	
	/**
	 * Gets the name of the server to which the player is connected
	 */
	public static final String GetServer = "BungeeCord";
	
	/**
	 * Send a plugin message to a server |OR| ALL the servers
	 * 
	 * @param String
	 *            - name of server (as defined in BungeeCord config.yml) |OR|
	 *            ALL (for global count)
	 * @param String
	 *            - subchannel
	 * @param Short
	 *            - size of message
	 * @param Byte
	 *            [] - message
	 */
	public static final String Forward = "BungeeCord";
	
	/**
	 * Gets the UUID of the player
	 */
	public static final String UUID = "BungeeCord";
	
	/**
	 * Gets the UUID of a player
	 * 
	 * @param String
	 *            - name of player
	 */
	public static final String UUIDOther = "BungeeCord";
	
	/**
	 * Gets the IP of a server
	 * 
	 * @param String
	 *            - name of server
	 */
	public static final String ServerIP = "BungeeCord";
}
