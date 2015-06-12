package xt449.Utilities;

import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.Set;

public class UtilitiesScoreboard {

	private Scoreboard scoreboard;

	public UtilitiesScoreboard(Scoreboard scoreboard) {
		this.scoreboard = scoreboard;
	}

	protected final void addEntry(String entry, Team team) {
		team.addEntry(entry);
	}

	protected final Team addTeam(String team) {
		return scoreboard.registerNewTeam(team);
	}

	protected final boolean getAllowFriendlyFire(Team team) {
		return team.allowFriendlyFire();
	}

	protected final boolean getCanSeeFriendlyInvisibles(Team team) {
		return team.canSeeFriendlyInvisibles();
	}

	protected final String getDisplayName(Team team) {
		return team.getDisplayName();
	}

	protected final Set<String> getEntries(Team team) {
		return team.getEntries();
	}

	protected final String getName(Team team) {
		return team.getName();
	}

	protected final NameTagVisibility getNameTagVisibility(Team team) {
		return team.getNameTagVisibility();
	}

	protected final Team getEntryTeam(String entry) {
		return scoreboard.getEntryTeam(entry);
	}

	protected final String getPrefix(Team team) {
		return team.getPrefix();
	}

	protected final String getSuffix(Team team) {
		return team.getSuffix();
	}

	protected final Team getTeam(String team) {
		return scoreboard.getTeam(team);
	}

	protected final boolean hasEntry(Team team, String entry) {
		return team.hasEntry(entry);
	}

	protected final boolean removeEntry(String entry, Team team) {
		return team.removeEntry(entry);
	}

	protected final void removeTeam(Team team) {
		team.unregister();
	}

	protected final void setTeamAllowFriendlyFire(Team team, boolean enabled) {
		team.setAllowFriendlyFire(enabled);
	}

	protected final void setTeamCanSeeFriendlyInvisibles(Team team, boolean enabled) {
		team.setCanSeeFriendlyInvisibles(enabled);
	}

	protected final void setTeamDisplayName(Team team, String display) {
		team.setDisplayName(display);
	}

	protected final void setTeamNameTagVisibility(Team team, NameTagVisibility visibility) {
		team.setNameTagVisibility(visibility);
	}

	protected final void setTeamPrefix(Team team, String prefix) {
		team.setPrefix(prefix);
	}

	protected final void setTeamSuffix(Team team, String suffix) {
		team.setSuffix(suffix);
	}
}
