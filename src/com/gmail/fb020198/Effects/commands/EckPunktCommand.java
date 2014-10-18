package com.gmail.fb020198.Effects.commands;

import com.gmail.fb020198.Effects.EffectsPlugin;
import com.gmail.fb020198.Effects.utils.CustomCommand;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * Made with <3
 * Made by Flo
 */
public class EckPunktCommand extends CustomCommand {
    public static final String CONFIG_NODE_ECKE_1 = "corner.1.";
    public static final String CONFIG_NODE_ECKE_2 = "corner.2.";

    public EckPunktCommand()
    {
        super("corner");
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player))
        {
            commandSender.sendMessage(ChatColor.RED + "Befehl muss als Spieler ausgeführt werden");
            return true;
        }
        Player player = (Player) commandSender;
        if(args.length != 1){
            player.sendMessage(ChatColor.RED + "Verwendung: /corner 1|2");
            return true;
        }
        FileConfiguration configuration = EffectsPlugin.getInstance().getConfig();
        String CONFIG_NODE;
        switch(args[0])
        {
            case "1":
                CONFIG_NODE = CONFIG_NODE_ECKE_1;
                break;
            case "2":
                CONFIG_NODE = CONFIG_NODE_ECKE_2;
                break;
            default:
                player.sendMessage(ChatColor.RED + "Verwendung: /corner 1|2");
                return true;
        }
        Location playerLocation = player.getLocation();
        configuration.set(CONFIG_NODE + "world", playerLocation.getWorld().getName());
        configuration.set(CONFIG_NODE + "x", playerLocation.getX());
        configuration.set(CONFIG_NODE + "y", playerLocation.getY());
        configuration.set(CONFIG_NODE + "z", playerLocation.getZ());
        configuration.set(CONFIG_NODE + "yaw", playerLocation.getYaw());
        configuration.set(CONFIG_NODE + "pitch", playerLocation.getPitch());
        EffectsPlugin.getInstance().saveConfig();
        EffectsPlugin.getInstance().reloadConfig();
        return true;
    }
}
