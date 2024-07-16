package se.svenskminecraft.svenskminecraft;

import com.destroystokyo.paper.profile.PlayerProfile;
import io.papermc.paper.ban.BanListType;
import org.bukkit.BanEntry;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.time.Duration;
import java.time.Instant;

public class Events implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("Welcome to the server!");
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.getPlayer().sendMessage("Player died!!");
        PlayerProfile profile = event.getPlayer().getPlayerProfile();
        // BanEntry entry = Bukkit.getBanList(BanListType.PROFILE).getBanEntry(profile);
        Duration duration = Duration.ofDays(7);
        String msg = String.format("Du har är död, men får en ny chans om %s", duration.toString());
        Bukkit.getBanList(BanListType.PROFILE).addBan(profile, msg, duration, "");
    }

}
