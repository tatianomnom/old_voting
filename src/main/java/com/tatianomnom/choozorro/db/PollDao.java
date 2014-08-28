package com.tatianomnom.choozorro.db;

import javax.inject.Inject;

import org.mybatis.guice.transactional.Transactional;

/**
 * TODO add description
 */
public class PollDao {

    private final PollMapper pollMapper;

    @Inject
    public PollDao(PollMapper pollMapper) {
        this.pollMapper = pollMapper;
    }

    @Transactional
    public void addPoll(Poll Poll) {
        pollMapper.insertPoll(Poll);
    }

    @Transactional
    public Poll findPoll(int id) {
        return pollMapper.selectPoll(id);
    }
    
}
