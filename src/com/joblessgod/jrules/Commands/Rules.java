package com.joblessgod.jrules.Commands;

import com.joblessgod.jrules.JRules;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Rules implements CommandExecutor {
    private final JRules plugin;

    public Rules(JRules plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("JRules")) {
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                // Reload the configuration
                plugin.reloadConfig();

                // Send feedback to the command sender
                sender.sendMessage("§aJRules configuration reloaded successfully!");
            } else {
                // Incorrect usage
                sender.sendMessage("§cUsage: /JRules reload");
            }
            return true;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command!");
            return true; // Exit early since it's a non-player
        }

        if (cmd.getName().equalsIgnoreCase("rule")) {
            Player player = (Player) sender;

            // Fetch the list of rules from the config
            List<String> rules = this.plugin.getConfig().getStringList("rules");

            // Check if the rules list is empty
            if (rules.isEmpty()) {
                player.sendMessage("§cNo rules have been set yet!");
                return true;
            }

            // Send each rule to the player
            for (String rule : rules) {
                player.sendMessage(rule);
            }
        }

        return true;
    }
}

