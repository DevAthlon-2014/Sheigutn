package com.gmail.fb020198.Effects.game;

import com.gmail.fb020198.Effects.EffectsPlugin;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Made with <3
 * Made by Flo
 */
public class Game {
    private static @Getter Powerup activePowerup = null;
    private static int powerUpScheduler;
    private static final Random RANDOM = new Random();
    private static List<Location> effectsList = new ArrayList<>();
    public static void start()
    {
        powerUpScheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(EffectsPlugin.getInstance(), () -> {
            List<Location> locList = EffectsPlugin.getInstance().getPlatForm().getBlockList();
            Location loc;
            do loc = locList.get(RANDOM.nextInt(locList.size()));
            while(effectsList.contains(loc));
            loc.getBlock().setType(Material.COAL_BLOCK);
            activePowerup = Powerup.values()[RANDOM.nextInt(Powerup.values().length)];
            Bukkit.getScheduler().scheduleSyncDelayedTask(EffectsPlugin.getInstance(), () -> loc.getBlock().setType(Material.AIR), 10*20L);
        }, 0L, 10 * 20L);
    }

    private static void createEffects()
    {
        for(Player p : Bukkit.getOnlinePlayers())
        {
            if(!())
        }
    }
}
