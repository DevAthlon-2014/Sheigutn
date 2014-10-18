package com.gmail.fb020198.Effects.game;

import com.gmail.fb020198.Effects.EffectsPlugin;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.function.Consumer;

/**
 * Made with <3
 * Made by Flo
 */
public enum Powerup {
    SPEED(player -> player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 3, 2))),
    INVISIBILITY(player -> player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 3, 1))),
    STICK(player ->{
        ItemStack item = new ItemStack(Material.STICK);
        item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
        Bukkit.getScheduler().scheduleSyncDelayedTask(EffectsPlugin.getInstance(), () -> player.getInventory().removeItem(item));
    });

    private Consumer<Player> consumer;
    private Powerup(Consumer<Player> playerConsumer)
    {
        consumer = playerConsumer;
    }

    public void activate(Player player)
    {
        consumer.accept(player);
        player.sendMessage(ChatColor.RED + "Du hast ein Powerup erhalten!");
    }
}
