package com.crazy.fragmentnavigation.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Mike
 */
public class Stuff {
    private static final AtomicInteger SEQUENCE = new AtomicInteger();

    public static String getNextTag() {
        return String.valueOf(SEQUENCE.getAndIncrement());
    }
}
