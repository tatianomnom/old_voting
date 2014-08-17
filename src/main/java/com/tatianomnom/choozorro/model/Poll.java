package com.tatianomnom.choozorro.model;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO add description
 */
public class Poll {

    //shall I store it here? or better call DAO by urlId?
/*    private final int id;

    private final String urlId;*/

    private final String description;

    private final List<String> options = new ArrayList<>();

    private final List<String> ratings = new ArrayList<>();

    public Poll(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
