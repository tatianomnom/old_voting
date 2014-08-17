package com.tatianomnom.choozorro.service;

import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * TODO add description
 */
public class UuidGenerator implements StringIdGenerator {

    @Override
    public String generateId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
