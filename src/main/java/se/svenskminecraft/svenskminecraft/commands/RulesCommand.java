package se.svenskminecraft.svenskminecraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import se.svenskminecraft.svenskminecraft.SvenskMinecraft;

public class RulesCommand implements CommandExecutor {

    private final SvenskMinecraft plugin;

    public RulesCommand(SvenskMinecraft plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§aRegler:");
        for (String rule : plugin.getConfig().getStringList("rules")) {
            sender.sendMessage(rule);
        }
        return true;
    }
}
