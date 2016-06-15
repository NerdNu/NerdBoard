package nu.nerd.nerdboard;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class NerdBoardListener implements Listener {


    private NerdBoard plugin;


    public NerdBoardListener() {
        plugin = NerdBoard.instance;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().setScoreboard(plugin.scoreboard);
    }


}
