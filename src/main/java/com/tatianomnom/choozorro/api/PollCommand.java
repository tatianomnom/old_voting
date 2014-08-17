package com.tatianomnom.choozorro.api;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * TODO add description
 */
public class PollCommand {
    private final String description;
    private final List<String> options;

    //TODO currently 'required' actually does nothing
    public PollCommand(@JsonProperty(value = "description", required = true) String description,
                       @JsonProperty(value = "options", required = true) List<String> options) {
        this.description = description;
        this.options = Collections.unmodifiableList(options);
    }

    public String getDescription() {
        return description;
    }

    public List<String> getOptions() {
        return options;
    }


    //TODO recall equals and hashCode best practices from Effective Java
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PollCommand that = (PollCommand) o;

        return description.equals(that.description) && options.equals(that.options);

    }

    @Override
    public int hashCode() {
        int result = description.hashCode();
        result = 31 * result + options.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PollCommand{" +
                "description='" + description + '\'' +
                ", options=" + options +
                '}';
    }
}
