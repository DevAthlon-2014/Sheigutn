package com.gmail.fb020198.Effects.listeners;

import com.gmail.fb020198.Effects.EffectsPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Made with <3
 * Made by Flo
 */
public class JoinListener {
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
    }
}
