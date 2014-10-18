package com.gmail.fb020198.Effects.utils;

import lombok.Getter;

/**
 * Made with <3
 * Made by Flo
 */
public enum TonData {
    WEISS(0),
    ORANGE(1),
    MAGENTA(2),
    HELLBLAU(3),
    GELB(4),
    HELLGRUEN(5),
    ROSA(6),
    GRAU(7),
    HELLGRAU(8),
    TUERKIS(9),
    VIOLETT(10),
    BLAU(11),
    BRAUN(12),
    GRUEN(13),
    ROT(14),
    SCHWARZ(15);
    private @Getter byte meta;
    private TonData(int meta)
    {
        this.meta = (byte) meta;
    }
}
