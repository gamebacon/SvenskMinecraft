package se.svenskminecraft.svenskminecraft;

import org.bukkit.plugin.java.JavaPlugin;
import se.svenskminecraft.svenskminecraft.commands.FAQCommand;
import se.svenskminecraft.svenskminecraft.commands.RulesCommand;

public final class SvenskMinecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerEvents(this), this);

        getCommand("regler").setExecutor(new RulesCommand(this));
        getCommand("faq").setExecutor(new FAQCommand(this));

        getLogger().info("SvenskMinecraft has been enabled!");
    }

    @Override
    public void onDisable() {
    }
}
