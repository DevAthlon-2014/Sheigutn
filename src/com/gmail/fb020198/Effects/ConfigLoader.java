package com.gmail.fb020198.Effects;

import com.gmail.fb020198.Effects.commands.SpawnPointCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Made with <3
 * Made by Flo
 */
public class ConfigLoader {

    public static Location loadSpawnPoint()
    {
        FileConfiguration config = EffectsPlugin.getInstance().getConfig();
        try{
            String node = SpawnPointCommand.SPAWN_CONFIG_NODE;
            return new Location(Bukkit.getWorld(config.getString(node + "world")),
                    config.getDouble(node + "x"),
                    config.getDouble(node + "y"),
                    config.getDouble(node + "z"),
                    (float)config.getDouble(node + "yaw"),
                    (float) config.getDouble(node + "pitch"));
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    public static Location loadEckpunkt1()
    {
        FileConfiguration config = EffectsPlugin.getInstance().getConfig();
    }

    public static Location loadEckpunkt2()
    {
        FileConfiguration config = EffectsPlugin.getInstance().getConfig();
    }
}
