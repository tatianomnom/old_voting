package com.tatianomnom.choozorro.service;

import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * TODO add description
 * TODO make one real and one for testing, with non-random UUID's
 */
public class UuidGenerator implements StringIdGenerator {

    @Override
    public String generateId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
