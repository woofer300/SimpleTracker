package dev.woofer.simpletracker.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CommandCoords implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        // Make sure a username was provided
        if (args.length < 1) {
            sender.sendMessage(ChatColor.RED + "Please include a player to locate. Usage: /coords <username>");
            return true;
        }
        String playerToBeLocatedName = args[0];
        Player playerToBeLocated = Bukkit.getPlayer(playerToBeLocatedName);
        // Make sure the player that is trying to be tracked exists
        if (playerToBeLocated == null) {
            sender.sendMessage("Player with name " + playerToBeLocatedName + " not found!");
            return true;
        }
        Location playerLocation = playerToBeLocated.getLocation();
        boolean locatingSelf = sender.getName().equals(playerToBeLocatedName);
        String message =
            (locatingSelf ? "You are " : playerToBeLocatedName + " is ") +
            "at coordinates " +
            Math.round(playerLocation.getX()) +
            " " +
            Math.round(playerLocation.getY()) +
            " " +
            Math.round(playerLocation.getZ()) +
            " in " +
            switch (Objects.requireNonNull(playerLocation.getWorld()).getEnvironment()) {
                case NORMAL -> "the overworld.";
                case NETHER -> "the nether.";
                case THE_END -> "the end.";
                default -> "an unknown dimension.";
            };
        sender.sendMessage(message);
        if (!locatingSelf && sender instanceof Player) playerToBeLocated.sendMessage(sender.getName() + " tracked you!");
        return true;
    }
}
