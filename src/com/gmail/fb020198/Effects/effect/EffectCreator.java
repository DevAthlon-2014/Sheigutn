package com.gmail.fb020198.Effects.effect;

import com.comphenix.packetwrapper.WrapperPlayServerWorldParticles;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.List;

/**
 * Made with <3
 * Made by Flo
 */
public class EffectCreator {
    /**
     * Erstellt einen linearen Effekt
     * @param startLoc Startposition
     * @param endLoc Endposition
     * @param effect Zu anzeigender Effekt
     * @param count Anzahl der Partikel
     */
    public static void linear(List<Player> playerList, Location startLoc, Location endLoc, WrapperPlayServerWorldParticles.ParticleEffect effect, int count)
    {
        double distance = endLoc.distance(startLoc);
        double multi = distance / (count - 1);
        Vector direction = endLoc.toVector().subtract(startLoc.toVector()).normalize().multiply(1);
        World w = startLoc.getWorld();
        for(double d = 0; d <= distance; d += multi)
        {
            WrapperPlayServerWorldParticles particlePacket = createPacket(effect, startLoc);
            sendTo(playerList, particlePacket);
            startLoc = startLoc.add(direction);
        }
    }


    public static void circular(List<Player> playerList, Location middle, WrapperPlayServerWorldParticles.ParticleEffect effect, double radius, double lineCount, double height) {
        double counter = height / (lineCount - 1);
        for (double y = 0; y <= height; y += counter) {
            for (double deg = 0; deg < 360; deg += 6) {
                double rad = deg * Math.PI / 180;
                double x = radius * Math.sin(rad);
                double z = radius * Math.cos(rad);
                Location playAt = middle.clone().add(x, y, z);
                WrapperPlayServerWorldParticles particlePacket = createPacket(effect, playAt);
                sendTo(playerList, particlePacket);
            }
        }
    }

    public static void spiral(List<Player> playerList, Location middle, WrapperPlayServerWorldParticles.ParticleEffect effect, double effectsPerRound, double radius, double height) {
        double deg = 0;
        for (double y = 0; y <= height; y += 0.02) {
            double rad = deg * Math.PI / 180;
            double x = radius * Math.sin(rad);
            double z = radius * Math.cos(rad);
            Location playAt = middle.clone().add(x, y, z);
            WrapperPlayServerWorldParticles particlePacket = createPacket(effect, playAt);
            sendTo(playerList, particlePacket);
            deg += (360 / effectsPerRound);
        }
    }

    public static void spiral(List<Player> playerList, Location middle, WrapperPlayServerWorldParticles.ParticleEffect effect, double radius, double height) {
        double deg = 0;
        for (double y = 0; y <= height; y += 0.02) {
            double rad = deg * Math.PI / 180;
            double x = radius * Math.sin(rad);
            double z = radius * Math.cos(rad);
            Location playAt = middle.clone().add(x, y, z);
            WrapperPlayServerWorldParticles particlePacket = createPacket(effect, playAt);
            sendTo(playerList, particlePacket);
            //playAt.getWorld().playEffect(playAt, effect, 0);
            deg += 6;
        }
    }

    private static final Vector nilVector = new Vector(0,0,0);
    private static WrapperPlayServerWorldParticles createPacket(WrapperPlayServerWorldParticles.ParticleEffect effect, Location loc)
    {
        WrapperPlayServerWorldParticles packet = new WrapperPlayServerWorldParticles();
        packet.setLocation(loc);
        packet.setOffset(nilVector);
        packet.setNumberOfParticles(1);
        return packet;
    }

    private static void sendTo(List<Player> playerList, WrapperPlayServerWorldParticles particlePacket)
    {
        for(Player p : playerList)
        {
            particlePacket.sendPacket(p);
        }
    }
}
