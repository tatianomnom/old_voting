package com.tatianomnom.choozorro.api;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * TODO add description
 * TODO move inside PollResource? who needs it outside controller
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PollCommand {
    private final String description;
    private final List<String> options;
    private final String url;
    private final Integer maxSubmits;

    //TODO currently 'required' actually does nothing
    public PollCommand(@JsonProperty(value = "description", required = true) String description,
                       @JsonProperty(value = "options", required = true) List<String> options,
                       @JsonProperty(value = "url") String url,
                       @JsonProperty(value = "maxSubmits") Integer maxSubmits) {
        this.description = description;
        this.options = Collections.unmodifiableList(options);
        this.url = url;
        this.maxSubmits = maxSubmits;
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

    public Integer getMaxSubmits() {
        return maxSubmits;
    }

    //TODO recall equals and hashCode best practices from Effective Java

    //TODO test these methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PollCommand that = (PollCommand) o;

        return description.equals(that.description)
                && !(maxSubmits != null ? !maxSubmits.equals(that.maxSubmits) : that.maxSubmits != null)
                && options.equals(that.options)
                && !(url != null ? !url.equals(that.url) : that.url != null);
    }

    @Override
    public int hashCode() {
        int result = description.hashCode();
        result = 31 * result + options.hashCode();
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (maxSubmits != null ? maxSubmits.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PollCommand{" +
                "description='" + description + '\'' +
                ", options=" + options +
                ", url='" + url + '\'' +
                ", maxSubmits=" + maxSubmits +
                '}';
    }
}
