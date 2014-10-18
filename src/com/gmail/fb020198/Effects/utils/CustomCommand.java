package com.gmail.fb020198.Effects.utils;

import com.gmail.fb020198.Effects.EffectsPlugin;
import org.bukkit.command.CommandExecutor;

/**
 * Made with <3
 * Made by Flo
 */
public abstract class CustomCommand implements CommandExecutor{
    public CustomCommand(String name)
    {
        EffectsPlugin.getInstance().getCommand(name).setExecutor(this);
    }
}
