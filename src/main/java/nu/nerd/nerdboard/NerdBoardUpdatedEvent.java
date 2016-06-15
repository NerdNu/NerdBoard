package nu.nerd.nerdboard;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


/**
 * The common scoreboard has been updated, which may concern other plugins
 */
public class NerdBoardUpdatedEvent extends Event {


    public enum UpdateReason {
        ADD_TEAM, REMOVE_TEAM, ADD_ENTRY, REMOVE_ENTRY
    }


    private static final HandlerList handlers = new HandlerList();
    private UpdateReason reason;


    public NerdBoardUpdatedEvent(UpdateReason reason) {
        this.reason = reason;
    }


    public UpdateReason getReason() {
        return reason;
    }


    public HandlerList getHandlers() {
        return handlers;
    }


    public static HandlerList getHandlerList() {
        return handlers;
    }


}
