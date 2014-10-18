package com.gmail.fb020198.Effects.utils;

import com.gmail.fb020198.Effects.EffectsPlugin;
import org.bukkit.event.Listener;

/**
 * Made with <3
 * Made by Flo
 */
public abstract class CustomListener implements Listener{

    public CustomListener()
    {
        EffectsPlugin.getInstance().getServer().getPluginManager().registerEvents(this, EffectsPlugin.getInstance());
    }
}
