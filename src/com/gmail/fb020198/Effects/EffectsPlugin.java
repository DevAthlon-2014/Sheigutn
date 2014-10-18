package com.gmail.fb020198.Effects;

import com.gmail.fb020198.Effects.commands.EckPunktCommand;
import com.gmail.fb020198.Effects.listeners.JoinListener;
import com.gmail.fb020198.Effects.world.CleanChunkGenerator;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
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
    private @Getter boolean started;
    private static final String worldName =  "Platform";
    @Override
    public void onEnable() {
        instance = this;
        World w = this.getServer().createWorld(new WorldCreator(worldName).generator(new CleanChunkGenerator()));
        //Location spawnPoint = ConfigLoader.loadSpawnPoint();
        Location eckPunkt1 = new Location(w, 0, 60, 0);//ConfigLoader.loadEckpunkt1();
        Location eckPunkt2 = new Location(w, 20, 60, 20);//ConfigLoader.loadEckpunkt2();
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
            platForm = new Platform(eckPunkt1, eckPunkt2);
            platForm.generate();
            new JoinListener();
            new EckPunktCommand();
            startGame(); //TODO
        }
    }


    @Override
    public void onDisable() {
        instance = null;
    }

    private void startGame()
    {
        started = true;
    }
}
