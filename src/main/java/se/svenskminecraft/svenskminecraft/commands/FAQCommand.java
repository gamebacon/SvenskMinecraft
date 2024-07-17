package se.svenskminecraft.svenskminecraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import se.svenskminecraft.svenskminecraft.SvenskMinecraft;

public class FAQCommand implements CommandExecutor {

    private final SvenskMinecraft plugin;

    public FAQCommand(SvenskMinecraft plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§aServer FAQ:");
        for (String faq : plugin.getConfig().getStringList("faq")) {
            sender.sendMessage("§7- " + faq);
        }
        return true;
    }
}
