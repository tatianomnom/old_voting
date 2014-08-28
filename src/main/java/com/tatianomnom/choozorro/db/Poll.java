package com.tatianomnom.choozorro.db;

import java.sql.Timestamp;

/**
 * TODO add description
 */
public class Poll {

    private Timestamp timestamp;

    private String creatorSession;

    private String votingUrlToken;

    private String trackingUrlToken;

    public Poll(Timestamp timestamp, String creatorSession, String votingUrlToken, String trackingUrlToken) {
        this.timestamp = timestamp;
        this.creatorSession = creatorSession;
        this.votingUrlToken = votingUrlToken;
        this.trackingUrlToken = trackingUrlToken;
    }

    private Poll() {
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getCreatorSession() {
        return creatorSession;
    }

    public String getVotingUrlToken() {
        return votingUrlToken;
    }

    public String getTrackingUrlToken() {
        return trackingUrlToken;
    }
}
