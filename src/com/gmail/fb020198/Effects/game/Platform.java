package com.gmail.fb020198.Effects.game;

import com.gmail.fb020198.Effects.utils.TonData;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Made with <3
 * Made by Flo
 */
@Getter
public class Platform {

    private Location eckPunkt1;
    private Location eckPunkt2;
    private List<Location> blockList = new ArrayList<>();
    private static final Random RANDOM = new Random();
    private Location spawnPoint;

    /**
     * Erstellt eine neue Plattform
     * @param eckPunkt1 Der Eckpunkt Nummer 1
     * @param eckPunkt2 Der Eckpunkt Nummer 2
     */
    public Platform(Location eckPunkt1, Location eckPunkt2)
    {
        if(eckPunkt1.equals(eckPunkt2)) throw new IllegalArgumentException("Eckpunkte müssen sich unterscheiden");
        if(!eckPunkt1.getWorld().equals(eckPunkt2.getWorld())) throw new IllegalArgumentException("Welten müssen übereinstimmen");
        if(eckPunkt1.getBlockY() != eckPunkt2.getY()) throw new IllegalArgumentException("Y-Koordinaten müssen übereinstimmen");
        this.eckPunkt1 = eckPunkt1;
        this.eckPunkt2 = eckPunkt2;
    }

    public void generate()
    {
        int minX = (int )Math.min(eckPunkt1.getX(), eckPunkt2.getX());
        int maxX = (int) Math.max(eckPunkt1.getX(), eckPunkt2.getX());
        int minZ = (int) Math.min(eckPunkt1.getZ(), eckPunkt2.getZ());
        int maxZ = (int) Math.max(eckPunkt1.getZ(), eckPunkt2.getZ());
        spawnPoint = eckPunkt1.clone();
        spawnPoint.setX((minX + maxX) / 2);
        spawnPoint.setZ((minZ + maxZ) / 2);
        spawnPoint = spawnPoint.add(0, 2, 0);
        for(int x = minX; x < maxX; x++)
        {
            for(int z = minZ; z < maxZ; z++)
            {
                Location blockLocation = new Location(eckPunkt1.getWorld(), x, eckPunkt1.getBlockY(), z);
                Block block = blockLocation.getBlock();
                block.setType(Material.STAINED_CLAY);
                block.setData(
                        TonData.values()[
                                RANDOM.nextInt(TonData.values().length)]
                                .getMeta());
                blockList.add(blockLocation.add(0, 1, 0));
            }
        }
    }
}
