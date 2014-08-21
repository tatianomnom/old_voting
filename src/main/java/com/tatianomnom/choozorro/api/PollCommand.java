package com.tatianomnom.choozorro.api;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * TODO add description
 * TODO move inside PollResource? who needs it outside controller
 * TODO add something like maxSubmitsNum, otherwise someone may clean cookies and submit multiple times
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PollCommand {
    private final String description;
    private final List<String> options;
    private final String url;

    //TODO currently 'required' actually does nothing
    public PollCommand(@JsonProperty(value = "description", required = true) String description,
                       @JsonProperty(value = "options", required = true) List<String> options,
                       @JsonProperty(value = "url") String url) {
        this.description = description;
        this.options = Collections.unmodifiableList(options);
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getUrl() {
        return url;
    }

    //TODO recall equals and hashCode best practices from Effective Java

    //TODO test these methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PollCommand that = (PollCommand) o;

        return !(description != null ? !description.equals(that.description) : that.description != null)
                && !(options != null ? !options.equals(that.options) : that.options != null)
                && !(url != null ? !url.equals(that.url) : that.url != null);

    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (options != null ? options.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PollCommand{" +
                "description='" + description + '\'' +
                ", options=" + options +
                ", url='" + url + '\'' +
                '}';
    }
}
