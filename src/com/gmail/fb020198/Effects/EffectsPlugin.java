package com.gmail.fb020198.Effects;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Made with <3
 * Made by Flo
 */
public class EffectsPlugin extends JavaPlugin{

    private @Getter Platform platForm;
    private static @Getter EffectsPlugin instance;
    @Override
    public void onEnable() {
        instance = this;
    }


    @Override
    public void onDisable() {
        instance = null;
    }
}
