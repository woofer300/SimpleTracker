package dev.woofer.simpletracker;

import dev.woofer.simpletracker.commands.CommandCoords;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleTracker extends JavaPlugin {
    @Override
    public void onDisable() {
        this.getLogger().info("SimpleTracker has been disabled!");
    }

    @Override
    public void onEnable() {
        this.getLogger().info("Starting SimpleTracker...");
        this.getCommand("coords").setExecutor(new CommandCoords());
        this.getLogger().info("SimpleTracker has been enabled!");
    }
}
