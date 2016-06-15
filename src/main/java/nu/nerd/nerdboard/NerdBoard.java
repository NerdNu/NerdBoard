package nu.nerd.nerdboard;

import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;


public class NerdBoard extends JavaPlugin {


    public static NerdBoard instance;
    protected Scoreboard scoreboard;


    public void onEnable() {
        NerdBoard.instance = this;
        scoreboard = getServer().getScoreboardManager().getNewScoreboard();
        new NerdBoardListener();
    }


    /**
     * Inform subscribed plugins that the player/team situation has been changed
     * @param reason what changed
     */
    public void sendUpdatedEvent(NerdBoardUpdatedEvent.UpdateReason reason) {
        NerdBoardUpdatedEvent event = new NerdBoardUpdatedEvent(reason);
        getServer().getPluginManager().callEvent(event);
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
        sendUpdatedEvent(NerdBoardUpdatedEvent.UpdateReason.ADD_TEAM);
        return scoreboard.registerNewTeam(name);
    }


    /**
     * Safely remove a team from the scoreboard, notifying listening plugins.
     * Use this instead of directly calling unregister() on the team object.
     * @param name The name of the team to remove
     */
    public void removeTeam(String name) {
        sendUpdatedEvent(NerdBoardUpdatedEvent.UpdateReason.REMOVE_TEAM);
        scoreboard.getTeam(name).unregister();
    }


    /**
     * Add a player to the specified team, notifying listening plugins.
     * Use this instead of directly calling addPlayer() on the team object.
     * @param team The team to add the player to
     * @param player The Player or OfflinePlayer to add to the team.
     * @deprecated The Bukkit API prefers you use addEntryToTeam()
     */
    public void addPlayerToTeam(Team team, OfflinePlayer player) {
        sendUpdatedEvent(NerdBoardUpdatedEvent.UpdateReason.ADD_ENTRY);
        team.addPlayer(player);
    }


    /**
     * Add an entry to the specified team, notifying listening plugins.
     * Use this instead of directly calling addEntry() on the team object.
     * @param team The team to add the player to
     * @param entry The entry to add to the team
     */
    public void addEntryToTeam(Team team, String entry) {
        sendUpdatedEvent(NerdBoardUpdatedEvent.UpdateReason.ADD_ENTRY);
        team.addEntry(entry);
    }


    /**
     * Remove a player from the specified team, notifying listening plugins.
     * Use this instead of directly calling removePlayer() on the team object.
     * @param team The team to remove the player from
     * @param player The Player or OfflinePlayer to remove
     * @deprecated The Bukkit API prefers you use removeEntryFromTeam()
     */
    public void removePlayerFromTeam(Team team, OfflinePlayer player) {
        sendUpdatedEvent(NerdBoardUpdatedEvent.UpdateReason.REMOVE_ENTRY);
        team.removePlayer(player);
    }


    /**
     * Remove an entry from the specified team, notifying listening plugins.
     * Use this instead of directly calling removeEntry() on the team object.
     * @param team The team to remove the entry from
     * @param entry The entry to remove from the team
     */
    public void removeEntryFromTeam(Team team, String entry) {
        sendUpdatedEvent(NerdBoardUpdatedEvent.UpdateReason.REMOVE_ENTRY);
        team.removeEntry(entry);
    }


}
