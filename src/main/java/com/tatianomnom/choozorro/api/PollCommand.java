package com.tatianomnom.choozorro.api;

import java.util.Collections;
import java.util.List;

/**
 * TODO add description
 */
public class PollCommand {
    private final String description;
    private final List<String> options;

    public PollCommand(String description, List<String> options) {
        this.description = description;
        this.options = Collections.unmodifiableList(options);
    }

    public String getDescription() {
        return description;
    }

    public List<String> getOptions() {
        return options;
    }
}
