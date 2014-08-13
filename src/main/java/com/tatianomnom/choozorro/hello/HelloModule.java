package com.tatianomnom.choozorro.hello;

import com.google.inject.Binder;
import com.google.inject.Module;

public class HelloModule implements Module {
    public void configure(final Binder binder) {
        binder.bind(HelloResource.class);
        binder.bind(Greeter.class).to(DefaultGreeter.class);
    }
}
