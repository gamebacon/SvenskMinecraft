package se.svenskminecraft.svenskminecraft;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("Welcome to the server!");
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.getPlayer().sendMessage("Player died!!");
    }
}
