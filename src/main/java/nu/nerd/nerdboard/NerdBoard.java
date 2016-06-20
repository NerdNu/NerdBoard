package nu.nerd.nerdboard;

import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;


public class NerdBoard extends JavaPlugin {


    public static NerdBoard instance;
    protected Scoreboard scoreboard;


    public void onEnable() {
        NerdBoard.instance = this;
        scoreboard = getServer().getScoreboardManager().getMainScoreboard();
        new NerdBoardListener();
    }


    /**
     * Get the scoreboard object for use by an external plugin.
     * @return the scoreboard
     */
    public Scoreboard getScoreboard() {
        return scoreboard;
    }


    /**
     * Safely add a new team to the scoreboard, notifying listening plugins.
     * Use this instead of directly calling registerNewTeam() on the scoreboard.
     * @param name The name of the team to add
     * @return the newly added team
     */
    public Team addTeam(String name) {
        Team team = scoreboard.registerNewTeam(name);
        NerdBoardUpdatedTeamsEvent event = new NerdBoardUpdatedTeamsEvent(UpdateReason.ADD_TEAM, name);
        getServer().getPluginManager().callEvent(event);
        return team;
    }


    /**
     * Safely remove a team from the scoreboard, notifying listening plugins.
     * Use this instead of directly calling unregister() on the team object.
     * @param name The name of the team to remove
     */
    public void removeTeam(String name) {
        scoreboard.getTeam(name).unregister();
        NerdBoardUpdatedTeamsEvent event = new NerdBoardUpdatedTeamsEvent(UpdateReason.REMOVE_TEAM, name);
        getServer().getPluginManager().callEvent(event);
    }


    /**
     * Add a player to the specified team, notifying listening plugins.
     * Use this instead of directly calling addPlayer() on the team object.
     * @param team The team to add the player to
     * @param player The Player or OfflinePlayer to add to the team.
     * @deprecated The Bukkit API prefers you use addEntryToTeam()
     */
    public void addPlayerToTeam(Team team, OfflinePlayer player) {
        team.addPlayer(player);
        NerdBoardUpdatedEntriesEvent event = new NerdBoardUpdatedEntriesEvent(UpdateReason.ADD_ENTRY, team, player);
        getServer().getPluginManager().callEvent(event);
    }


    /**
     * Add an entry to the specified team, notifying listening plugins.
     * Use this instead of directly calling addEntry() on the team object.
     * @param team The team to add the player to
     * @param entry The entry to add to the team
     */
    public void addEntryToTeam(Team team, String entry) {
        team.addEntry(entry);
        NerdBoardUpdatedEntriesEvent event = new NerdBoardUpdatedEntriesEvent(UpdateReason.ADD_ENTRY, team, entry);
        getServer().getPluginManager().callEvent(event);
    }


    /**
     * Remove a player from the specified team, notifying listening plugins.
     * Use this instead of directly calling removePlayer() on the team object.
     * @param team The team to remove the player from
     * @param player The Player or OfflinePlayer to remove
     * @deprecated The Bukkit API prefers you use removeEntryFromTeam()
     */
    public void removePlayerFromTeam(Team team, OfflinePlayer player) {
        team.removePlayer(player);
        NerdBoardUpdatedEntriesEvent event = new NerdBoardUpdatedEntriesEvent(UpdateReason.REMOVE_ENTRY, team, player);
        getServer().getPluginManager().callEvent(event);
    }


    /**
     * Remove an entry from the specified team, notifying listening plugins.
     * Use this instead of directly calling removeEntry() on the team object.
     * @param team The team to remove the entry from
     * @param entry The entry to remove from the team
     */
    public void removeEntryFromTeam(Team team, String entry) {
        team.removeEntry(entry);
        NerdBoardUpdatedEntriesEvent event = new NerdBoardUpdatedEntriesEvent(UpdateReason.REMOVE_ENTRY, team, entry);
        getServer().getPluginManager().callEvent(event);
    }


}
