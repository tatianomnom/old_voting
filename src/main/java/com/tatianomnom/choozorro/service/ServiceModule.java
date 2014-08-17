package com.tatianomnom.choozorro.service;

import com.google.inject.AbstractModule;

/**
 * TODO add description
 * TODO for test env, use sequential
 */
public class ServiceModule extends AbstractModule {
    public void configure() {
        bind(StringIdGenerator.class).to(UuidGenerator.class);
    }
}
