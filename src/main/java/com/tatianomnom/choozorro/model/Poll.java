package com.tatianomnom.choozorro.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * TODO add description
 */
public class Poll {
    private final String description;

    public Poll(@JsonProperty("description") String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
