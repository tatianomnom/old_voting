package com.tatianomnom.choozorro.service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO add description
 */
public class SequentialIdGenerator implements StringIdGenerator{

    private static final AtomicLong internalCounter = new AtomicLong(0L);

    @Override
    public String generateId() {
        return String.format("%032d", internalCounter.incrementAndGet());
    }
}
