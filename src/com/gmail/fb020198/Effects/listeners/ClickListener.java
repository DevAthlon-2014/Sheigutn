package com.gmail.fb020198.Effects.listeners;

import com.gmail.fb020198.Effects.game.Game;
import com.gmail.fb020198.Effects.utils.CustomListener;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Made with <3
 * Made by Flo
 */
public class ClickListener extends CustomListener{
    @EventHandler
    public void onClick(PlayerInteractEvent ev)
    {
        if(ev.getAction() == Action.RIGHT_CLICK_BLOCK || ev.getAction() == Action.LEFT_CLICK_BLOCK)
        {
            if(ev.getClickedBlock().getType() == Material.COAL_BLOCK)
            {
               Game.getActivePowerup().activate(ev.getPlayer());
               ev.getClickedBlock().setType(Material.AIR);
            }
        }
    }

}
