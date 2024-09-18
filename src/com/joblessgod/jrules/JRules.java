package com.joblessgod.jrules;

import com.joblessgod.jrules.Commands.Rules;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class JRules extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("rule").setExecutor(new Rules(this));
        getCommand("JRules").setExecutor(new Rules(this));
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[JRules] plugin has enabled!");
        saveDefaultConfig(); // saves config file
    }

    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[JRules] plugin has disabled!");
    }

}
