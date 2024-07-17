package se.svenskminecraft.svenskminecraft;

import com.destroystokyo.paper.profile.PlayerProfile;
import io.papermc.paper.ban.BanListType;
import io.papermc.paper.event.player.PlayerDeepSleepEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.regex.Pattern;

public class EntityEvents implements Listener {

    private SvenskMinecraft plugin;

    public EntityEvents(SvenskMinecraft plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onExplode(EntityExplodeEvent event) {
        plugin.getLogger().info("123" + event.getEntity().getType());
        if(event.getEntity().getType() == EntityType.CREEPER) {
            float explosion = (float) plugin.getConfig().getDouble("creeper-explosion");
            plugin.getLogger().info(">>>>>" + explosion);
            event.setYield(explosion);
        }
    }

}
