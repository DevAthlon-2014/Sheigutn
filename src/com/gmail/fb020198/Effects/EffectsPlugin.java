package com.gmail.fb020198.Effects;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

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
        //Location spawnPoint = ConfigLoader.loadSpawnPoint();
        Location eckPunkt1 = ConfigLoader.loadEckpunkt1();
        Location eckPunkt2 = ConfigLoader.loadEckpunkt2();
        if(eckPunkt1 == null)
        {
            getLogger().log(Level.SEVERE, "Fehler beim Loaden des Eckpunktes No1 aufgetreten");
        }
        if(eckPunkt2 == null)
        {
            getLogger().log(Level.SEVERE, "Fehler beim Loaden des Eckpunktes No2 aufgetreten");
        }
        if(!(eckPunkt1 == null && eckPunkt2 == null))
        {
            platForm = new Platform()
            startGame(); //TODO
        }
    }


    @Override
    public void onDisable() {
        instance = null;
    }

    private void startGame()
    {
        Plat
    }
}
