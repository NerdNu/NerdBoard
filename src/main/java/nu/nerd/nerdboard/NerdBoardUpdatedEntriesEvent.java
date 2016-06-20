package nu.nerd.nerdboard;

import org.bukkit.OfflinePlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.scoreboard.Team;


/**
 * The common scoreboard has been updated the entries, which may concern other plugins
 */
public class NerdBoardUpdatedEntriesEvent extends Event {


    private static final HandlerList handlers = new HandlerList();
    private UpdateReason reason;
    private Team team;
    private String entry = null;
    private OfflinePlayer player = null;


    public NerdBoardUpdatedEntriesEvent(UpdateReason reason, Team team, String entry) {
        this.reason = reason;
        this.team = team;
        this.entry = entry;
    }


    public NerdBoardUpdatedEntriesEvent(UpdateReason reason, Team team, OfflinePlayer player) {
        this.reason = reason;
        this.team = team;
        this.player = player;
    }


    public UpdateReason getReason() {
        return reason;
    }


    public Team getTeam() {
        return team;
    }


    public String getEntry() {
        return entry;
    }


    public OfflinePlayer getPlayer() {
        return player;
    }


    public HandlerList getHandlers() {
        return handlers;
    }


    public static HandlerList getHandlerList() {
        return handlers;
    }


}
