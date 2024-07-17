package se.svenskminecraft.svenskminecraft;

import com.destroystokyo.paper.profile.PlayerProfile;
import io.papermc.paper.ban.BanListType;
import io.papermc.paper.event.player.PlayerDeepSleepEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.regex.Pattern;

public class PlayerEvents implements Listener {

    private SvenskMinecraft plugin;
    private List<String> bannedWords;

    public PlayerEvents(SvenskMinecraft plugin) {
        this.plugin = plugin;
        bannedWords = plugin.getConfig().getStringList("banned-words");
    }

    @EventHandler
    public void onPlayerSleep(PlayerDeepSleepEvent event) {
        World world = event.getPlayer().getWorld();
        world.setTime(1_000);
        world.setStorm(false);
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        event.getPlayer().setGameMode(GameMode.SURVIVAL);
        System.out.println("surv!");
    }



    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage().toLowerCase();

        for (String word : bannedWords) {
            if (Pattern.compile("\\b" + Pattern.quote(word) + "\\b").matcher(message).find()) {
                event.setCancelled(true);
                PlayerProfile profile = event.getPlayer().getPlayerProfile();
                String msg = String.format("Du är banned för att ha brytit mot reglarna: \"%s\" ", word);
                Instant duration = null;
                Bukkit.getBanList(BanListType.PROFILE).addBan(profile, msg, duration, "");
                Bukkit.getScheduler().runTask(plugin, () -> event.getPlayer().kick(Component.text(msg)));
                return;
            }
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.getPlayer().setGameMode(GameMode.SURVIVAL);
        event.getPlayer().sendMessage("Player died!!");
        PlayerProfile profile = event.getPlayer().getPlayerProfile();
        Duration duration = Duration.ofDays(7);
        String msg = "Du dog.";
        Bukkit.getBanList(BanListType.PROFILE).addBan(profile, msg, duration, "");
        event.getPlayer().kick(Component.text(msg));
    }

}
