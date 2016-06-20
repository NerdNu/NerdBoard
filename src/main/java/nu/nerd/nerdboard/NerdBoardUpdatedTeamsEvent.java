package nu.nerd.nerdboard;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


/**
 * The common scoreboard has been updated the teams, which may concern other plugins
 */
public class NerdBoardUpdatedTeamsEvent extends Event {


    private static final HandlerList handlers = new HandlerList();
    private UpdateReason reason;
    private String team;


    public NerdBoardUpdatedTeamsEvent(UpdateReason reason, String team) {
        this.reason = reason;
        this.team = team;
    }


    public UpdateReason getReason() {
        return reason;
    }


    public String getTeam() {
        return team;
    }


    public HandlerList getHandlers() {
        return handlers;
    }


    public static HandlerList getHandlerList() {
        return handlers;
    }


}
