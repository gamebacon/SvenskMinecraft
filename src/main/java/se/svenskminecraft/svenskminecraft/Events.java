package se.svenskminecraft.svenskminecraft;

import com.destroystokyo.paper.profile.PlayerProfile;
import io.papermc.paper.ban.BanListType;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.time.Duration;

public class Events implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("Welcome to the server!");
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.getPlayer().sendMessage("Player died!!");
        PlayerProfile profile = event.getPlayer().getPlayerProfile();
        Duration duration = Duration.ofDays(7);
        String msg = "Du har är död tills vidare";
        Bukkit.getBanList(BanListType.PROFILE).addBan(profile, msg, duration, "123");
        event.getPlayer().kick();
    }

}
