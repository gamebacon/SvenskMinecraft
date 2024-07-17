package se.svenskminecraft.svenskminecraft;

import com.destroystokyo.paper.profile.PlayerProfile;
import io.papermc.paper.ban.BanListType;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.time.Duration;

public class PlayerEvents implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("Välkommen!");
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent  event) {
        event.getPlayer().setGameMode(GameMode.SURVIVAL);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.getPlayer().sendMessage("Player died!!");
        PlayerProfile profile = event.getPlayer().getPlayerProfile();
        Duration duration = Duration.ofDays(7);
        String msg = "Du dog.";
        Bukkit.getBanList(BanListType.PROFILE).addBan(profile, msg, duration, "123");
        Component deathMessage = event.deathMessage();
        PlayerKickEvent.Cause cause = PlayerKickEvent.Cause.BANNED;
        Component c = deathMessage.append(Component.text(msg));
        event.getPlayer().kick(c, cause);
    }

}
