package com.tatianomnom.choozorro.db;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * TODO add description
 */
public interface PollMapper {

    @Insert("INSERT INTO poll (timestamp, creator_session, voting_url_token, tracking_url_token)" +
            "VALUES (#{timestamp}, #{creatorSession}, #{votingUrlToken}, #{trackingUrlToken})")
    int insertPoll(Poll poll);

    @Select("SELECT timestamp, creator_session, voting_url_token, tracking_url_token" +
            "FROM poll WHERE id = #{id}")
    Poll selectPoll(int id);
}
