package com.tatianomnom.choozorro.api;

import com.google.inject.AbstractModule;
import com.tatianomnom.choozorro.api.resources.OptionResource;
import com.tatianomnom.choozorro.api.resources.PollResource;
import com.tatianomnom.choozorro.api.resources.RatingResource;
import com.tatianomnom.choozorro.api.resources.ResponseResource;
import com.tatianomnom.choozorro.api.resources.ResultResource;

/**
 * TODO add description
 */
public class ApiModule extends AbstractModule {
    public void configure() {
        bind(PollResource.class);
        bind(OptionResource.class);
        bind(RatingResource.class);
        bind(ResponseResource.class);
        bind(ResultResource.class);
    }
}
