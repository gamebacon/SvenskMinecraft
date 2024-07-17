package se.svenskminecraft.svenskminecraft;

import org.bukkit.plugin.java.JavaPlugin;
import se.svenskminecraft.svenskminecraft.commands.FAQCommand;
import se.svenskminecraft.svenskminecraft.commands.RulesCommand;

public final class SvenskMinecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
        getLogger().info("hej igen!");

        // Register commands
        if (getCommand("regler") != null) {
            System.out.println(getCommand("regler"));
            getCommand("regler").setExecutor(new RulesCommand(this));
        }
        if (getCommand("faq") != null) {
            System.out.println(getCommand("faq"));
            getCommand("faq").setExecutor(new FAQCommand(this));
        }

        getLogger().info("SvenskMinecraft has been enabled!!!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
