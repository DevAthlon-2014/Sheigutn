package com.gmail.fb020198.Effects.utils;

import com.gmail.fb020198.Effects.EffectsPlugin;
import com.gmail.fb020198.Effects.commands.EckPunktCommand;
import com.gmail.fb020198.Effects.commands.SpawnPointCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Made with <3
 * Made by Flo
 */
public class ConfigLoader {

    public static Location loadSpawnPoint() {
        FileConfiguration config = EffectsPlugin.getInstance().getConfig();
        String node = SpawnPointCommand.SPAWN_CONFIG_NODE;
        return loadLocationByConfigNode(config, node);
    }

    public static Location loadEckpunkt1() {
        FileConfiguration config = EffectsPlugin.getInstance().getConfig();
        return loadLocationByConfigNode(config, EckPunktCommand.CONFIG_NODE_ECKE_1);
    }

    public static Location loadEckpunkt2() {
        FileConfiguration config = EffectsPlugin.getInstance().getConfig();
        return loadLocationByConfigNode(config, EckPunktCommand.CONFIG_NODE_ECKE_2);
    }

    private static Location loadLocationByConfigNode(FileConfiguration config, String node) {
        try {
            return new Location(Bukkit.getWorld(config.getString(node + "world")),
                    config.getDouble(node + "x"),
                    config.getDouble(node + "y"),
                    config.getDouble(node + "z"),
                    (float) config.getDouble(node + "yaw"),
                    (float) config.getDouble(node + "pitch"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}