package com.gmail.fb020198.Effects.listeners;

import com.gmail.fb020198.Effects.EffectsPlugin;
import com.gmail.fb020198.Effects.game.Game;
import com.gmail.fb020198.Effects.utils.CustomListener;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Made with <3
 * Made by Flo
 */
public class JoinListener extends CustomListener{
    @EventHandler
    public void onJoin(PlayerJoinEvent ev)
    {
        /*if(!EffectsPlugin.getInstance().isStarted())
        {
            if(ev.getPlayer().hasPermission(Permissions.SET_CORNER))
            {
                ev.getPlayer().sendMessage("Die Eckpunkte müssen gesetzt werden.");
            }
        }*/
        ev.getPlayer().teleport(EffectsPlugin.getInstance().getPlatForm().getSpawnPoint());
        if(Bukkit.getOnlinePlayers().length == EffectsPlugin.getInstance().getRequiredPlayers())
        {
            Game.start();
        }
    }
}
