package com.joblessgod.jrules;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.List;

public class RuleListener implements Listener {

    private final JRules plugin;

    public RuleListener(JRules plugin) {
        this.plugin = plugin;
        Player Player = null;
        Player player = (Player);

        // grab the config value
        List<String> rules = this.plugin.getConfig().getStringList("rules");
        // Send each rule from the list
        for (String rule : rules) {
            player.sendMessage(rule);
        }
    }
}
