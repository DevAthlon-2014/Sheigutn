package com.gmail.fb020198.Effects;

import com.gmail.fb020198.Effects.utils.TonData;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
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
    private static final Random RANDOM = new Random(TonData.values().length);
    private @Setter Location spawnPoint;
    public Platform(Location eckPunkt1, Location eckPunkt2, Location spawnPoint)
    {
        if(!eckPunkt1.getWorld().equals(eckPunkt2.getWorld())) throw new IllegalArgumentException("Welten müssen übereinstimmen");
        if(eckPunkt1.getBlockY() != eckPunkt2.getY()) throw new IllegalArgumentException("Y-Koordinaten müssen übereinstimmen");
        this.eckPunkt1 = eckPunkt1;
        this.eckPunkt2 = eckPunkt2;
        this.spawnPoint = spawnPoint;
        int minX = (int )Math.min(eckPunkt1.getX(), eckPunkt2.getX());
        int maxX = (int) Math.max(eckPunkt1.getX(), eckPunkt2.getX());
        int minZ = (int) Math.min(eckPunkt1.getZ(), eckPunkt2.getZ());
        int maxZ = (int) Math.max(eckPunkt1.getZ(), eckPunkt2.getZ());
        for(int x = minX; x < maxX; x++)
        {
            for(int z = minZ; z < maxZ; z++)
            {
                Location blockLocation = new Location(eckPunkt1.getWorld(), x, eckPunkt1.getBlockY(), z);
                Block block = blockLocation.getBlock();
                block.setData(TonData.values()[RANDOM.nextInt()].getMeta());
                blockList.add(blockLocation.add(0, 1, 0));
            }
        }
    }
}
