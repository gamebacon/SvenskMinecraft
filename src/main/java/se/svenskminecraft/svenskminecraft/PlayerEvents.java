package se.svenskminecraft.svenskminecraft;

import com.destroystokyo.paper.profile.PlayerProfile;
import io.papermc.paper.ban.BanListType;
import io.papermc.paper.event.player.PlayerDeepSleepEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

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
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPlayedBefore()) {
            String msg = "Välkommen! kom igång med /regler och /faq";
            event.joinMessage(Component.text(msg));
        }
    }

    @EventHandler
    public void onPlayerSleep(PlayerDeepSleepEvent event) {
        World world = event.getPlayer().getWorld();
        world.setTime(1_000);
        world.setStorm(false);
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

}
