package se.svenskminecraft.svenskminecraft;

import org.bukkit.plugin.java.JavaPlugin;

public final class SvenskMinecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Hello world!");
        getServer().getPluginManager().registerEvents(new Events(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
