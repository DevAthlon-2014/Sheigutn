package com.gmail.fb020198.Effects.world;

import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

import java.util.Arrays;
import java.util.List;

/**
 * Made with <3
 * Made by Flo
 */
public class CleanChunkGenerator extends ChunkGenerator {
    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {
        return Arrays.asList(new CleanBlockPopulator());
    }
}
