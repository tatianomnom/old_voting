package com.tatianomnom.choozorro.api;

import com.google.inject.AbstractModule;

/**
 * TODO add description
 */
public class ApiModule extends AbstractModule {
    public void configure() {
        bind(PollResource.class);
    }
}
