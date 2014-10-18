package com.gmail.fb020198.Effects.commands;

import com.gmail.fb020198.Effects.EffectsPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * Made with <3
 * Made by Flo
 */
public class SpawnPointCommand extends CustomCommand{
    public static final String SPAWN_CONFIG_NODE = "spawn.";
    public SpawnPointCommand() {
        super("spawnpoint");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(!(commandSender instanceof Player))
        {
            commandSender.sendMessage(ChatColor.RED + "Befehl muss als Spieler ausgeführt werden");
            return true;
        }
        Player player = (Player) commandSender;
        FileConfiguration configuration = EffectsPlugin.getInstance().getConfig();
        Location playerLocation = player.getLocation();
        configuration.set(SPAWN_CONFIG_NODE + "world", playerLocation.getWorld().getName());
        configuration.set(SPAWN_CONFIG_NODE + "x", playerLocation.getX());
        configuration.set(SPAWN_CONFIG_NODE + "y", playerLocation.getY());
        configuration.set(SPAWN_CONFIG_NODE + "z", playerLocation.getZ());
        configuration.set(SPAWN_CONFIG_NODE + "yaw", playerLocation.getYaw());
        configuration.set(SPAWN_CONFIG_NODE + "pitch", playerLocation.getPitch());
        EffectsPlugin.getInstance().saveConfig();
        EffectsPlugin.getInstance().getPlatForm().setSpawnPoint(playerLocation);
        return true;
    }
}
