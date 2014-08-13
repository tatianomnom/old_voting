package com.tatianomnom.choozorro.service;

import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * TODO add description
 */
public class UuidGenerator {

    private final String input;

    @Inject
    public UuidGenerator(@Named("uuid") String input) {
        this.input = input;
    }

    public String generateUuid() {
        return UUID.randomUUID().toString() + input;
    }
}
