package com.tatianomnom.choozorro;

import com.google.inject.AbstractModule;
import com.tatianomnom.choozorro.api.ApiModule;
import com.tatianomnom.choozorro.db.DbModule;
import com.tatianomnom.choozorro.service.ServiceModule;

/**
 * TODO add description
 */
public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new ApiModule());
        install(new DbModule());
        install(new ServiceModule());
    }
}
