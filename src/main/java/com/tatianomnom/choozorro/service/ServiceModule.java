package com.tatianomnom.choozorro.service;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * TODO add description
 */
public class ServiceModule extends AbstractModule {
    public void configure() {
        bind(UuidGenerator.class);
        bind(String.class)
                .annotatedWith(Names.named("uuid"))
                .toInstance("azaza");
    }
}
