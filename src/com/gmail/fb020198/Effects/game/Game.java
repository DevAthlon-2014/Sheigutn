package com.gmail.fb020198.Effects.game;

import com.comphenix.packetwrapper.WrapperPlayServerWorldParticles;
import com.gmail.fb020198.Effects.EffectsPlugin;
import com.gmail.fb020198.Effects.effect.EffectCreator;
import com.gmail.fb020198.Effects.utils.Gamestate;
import lombok.Getter;
import org.bukkit.*;
import org.bukkit.entity.Player;
import static com.comphenix.packetwrapper.WrapperPlayServerWorldParticles.ParticleEffect.*;
import java.util.*;

/**
 * Made with <3
 * Made by Flo
 */
public class Game {
    private static @Getter List<UUID> notIngame = new ArrayList<>();
    private static @Getter Powerup activePowerup = null;
    private static int powerUpScheduler;
    private static final Random RANDOM = new Random();
    private static @Getter List<Location> effectsList = new ArrayList<>();
    private static @Getter List<UUID> safe = new ArrayList<>();
    public static void start()
    {
        for(Player p : Bukkit.getOnlinePlayers())
        {
            p.sendMessage(ChatColor.AQUA + "Das Spiel beginnt!");
        }
        EffectsPlugin.getInstance().setGameState(Gamestate.INGAME);
        powerUpScheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(EffectsPlugin.getInstance(), () -> {
            List<Location> locList = EffectsPlugin.getInstance().getPlatForm().getBlockList();
            final Location loc = locList.get(RANDOM.nextInt(locList.size()));
            loc.getBlock().setType(Material.COAL_BLOCK);
            activePowerup = Powerup.values()[RANDOM.nextInt(Powerup.values().length)];
            Bukkit.getScheduler().scheduleSyncDelayedTask(EffectsPlugin.getInstance(), () -> loc.getBlock().setType(Material.AIR), 10*20L);
        }, 0L, 10 * 20L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(EffectsPlugin.getInstance(), () -> {
            Game.createEffects();
        }, 3 * 20L);
    }

    public static void createEffects()
    {
        int count = -1;
        for(Player p : Bukkit.getOnlinePlayers())
        {
           if(!notIngame.contains(p.getUniqueId())) count++;
        }
        for(int i = 0; i < count; i++)
        {
            Bukkit.getScheduler().scheduleSyncDelayedTask(EffectsPlugin.getInstance(), () -> {
                        List<Location> locList = EffectsPlugin.getInstance().getPlatForm().getBlockList();
                        Location loc = locList.get(RANDOM.nextInt(locList.size()));
                        effectsList.add(loc);
                        EffectCreator.circular(Arrays.asList(Bukkit.getOnlinePlayers()), loc, WrapperPlayServerWorldParticles.ParticleEffect.HEART, 1, 5, 2);
                    }
            );
        }
    }
}
