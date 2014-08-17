package com.tatianomnom.choozorro.service;

import com.google.inject.AbstractModule;

/**
 * TODO add description
 */
public class ServiceModule extends AbstractModule {
    public void configure() {

        //TODO this is considered bad practice, what else to do without bloating the project?
        //this check could be performed many times. think about splitting to TestModule and ProductionModule?
        //or annotations?
        if ("ci".equals(System.getProperty("env"))) {
            bind(StringIdGenerator.class).to(SequentialIdGenerator.class);
        } else {
            bind(StringIdGenerator.class).to(UuidGenerator.class);
        }
    }
}
