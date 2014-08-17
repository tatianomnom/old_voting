package com.tatianomnom.choozorro.service;

/**
 * TODO add description
 */
public class SequentialIdGenerator implements StringIdGenerator{

    private static long internalCounter = 0L;

    @Override
    public String generateId() {
        internalCounter++;
        return String.format("%032d", internalCounter);
    }
}
