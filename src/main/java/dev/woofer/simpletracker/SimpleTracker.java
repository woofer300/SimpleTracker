package dev.woofer.simpletracker;

import dev.woofer.simpletracker.commands.CommandCoords;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleTracker extends JavaPlugin {
    @Override
    public void onDisable() {
        this.getLogger().info(ChatColor.RED + "SimpleTracker has been disabled!");
    }

    @Override
    public void onEnable() {
        this.getLogger().info("Starting SimpleTracker...");
        this.getCommand("coords").setExecutor(new CommandCoords());
        this.getLogger().info(ChatColor.GREEN + "SimpleTracker has been enabled!");
    }
}
