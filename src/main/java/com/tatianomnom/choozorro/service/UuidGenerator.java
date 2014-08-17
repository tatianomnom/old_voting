package com.tatianomnom.choozorro.service;

import java.util.UUID;


/**
 * TODO add description
 */
public class UuidGenerator implements StringIdGenerator {

    @Override
    public String generateId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
