package se.svenskminecraft.svenskminecraft;

import org.bukkit.plugin.java.JavaPlugin;
import se.svenskminecraft.svenskminecraft.commands.FAQCommand;
import se.svenskminecraft.svenskminecraft.commands.RulesCommand;

public final class SvenskMinecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getLogger().info("SvenskMinecraft has been enabled!");
        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);

        // Register commands
        if (getCommand("regler") != null) {
            getCommand("regler").setExecutor(new RulesCommand(this));
        }
        if (getCommand("faq") != null) {
            getCommand("faq").setExecutor(new FAQCommand(this));
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
