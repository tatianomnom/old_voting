package com.tatianomnom.choozorro.api;

import com.google.inject.AbstractModule;
import com.tatianomnom.choozorro.api.resources.RootResource;

/**
 * TODO add description
 */
public class ApiModule extends AbstractModule {
    public void configure() {
        bind(RootResource.class);
    }
}
