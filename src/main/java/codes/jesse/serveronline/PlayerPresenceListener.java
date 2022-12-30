package codes.jesse.serveronline;

import com.destroystokyo.paper.event.player.PlayerConnectionCloseEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerPresenceListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();
        new DiscordMessage("**" + playerName + "** has joined the server!").send();
    }

    @EventHandler
    public void onPlayerLeave(PlayerConnectionCloseEvent event) {
        String playerName = event.getPlayerName();
        new DiscordMessage("**" + playerName + "** has left the server.").send();
    }
}
