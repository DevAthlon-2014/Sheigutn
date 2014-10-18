package com.gmail.fb020198.Effects.listeners;

import com.gmail.fb020198.Effects.EffectsPlugin;
import com.gmail.fb020198.Effects.game.Game;
import com.gmail.fb020198.Effects.utils.CustomListener;
import com.gmail.fb020198.Effects.utils.Gamestate;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Iterator;
import java.util.UUID;

/**
 * Made with <3
 * Made by Flo
 */
public class MoveListener extends CustomListener{

    @EventHandler
    public void onMove(PlayerMoveEvent ev)
    {
        if(EffectsPlugin.getInstance().getGameState() == Gamestate.INGAME){
            //ev.getPlayer().sendMessage("T");
            if(!Game.getNotIngame().contains(ev.getPlayer().getUniqueId()))
            {
                if(!Game.getSafe().contains(ev.getPlayer().getUniqueId()))
                {
                    //ev.getPlayer().sendMessage("T");
                    for(Iterator<Location> it = Game.getEffectsList().iterator(); it.hasNext();) {
                        Location effect = it.next();
                        if (ev.getPlayer().getLocation().distance(effect) <= 0.5) {
                            Game.getSafe().add(ev.getPlayer().getUniqueId());
                            ev.getPlayer().sendMessage(ChatColor.GREEN + "Du bist safe!");
                            it.remove();
                            if (Game.getEffectsList().isEmpty()) {
                                if (Game.getSafe().size() == 1) {
                                    Bukkit.broadcastMessage(ChatColor.AQUA + ev.getPlayer().getName() + " hat das Spiel gewonnen!");
                                } else {
                                    /*for (Player p : Bukkit.getOnlinePlayers()) {
                                        if (!Game.getSafe().contains(p.getUniqueId())) {
                                            Game.getNotIngame().add(p.getUniqueId());
                                            p.setFlying(true);
                                            p.setAllowFlight(true);
                                            for (UUID uid : Game.getSafe()) {
                                                Player safe = Bukkit.getPlayer(uid);
                                                safe.hidePlayer(p);
                                            }
                                            return;
                                        }
                                    }*/
                                    Bukkit.broadcastMessage("Test");
                                    Game.getSafe().clear();
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(EffectsPlugin.getInstance(), () -> {
                                        Game.createEffects();
                                    }, 3 * 20L);
                                }
                            }
                        }
                    }
                }

            }
        }
        else{
            ev.getPlayer().teleport(ev.getFrom());
        }
    }
}
