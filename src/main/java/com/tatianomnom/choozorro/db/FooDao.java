package com.tatianomnom.choozorro.db;

import javax.inject.Inject;

import org.mybatis.guice.transactional.Transactional;

/**
 * TODO add description
 */
public class FooDao {

    private final FooMapper fooMapper;

    @Inject
    public FooDao(FooMapper fooMapper) {
        this.fooMapper = fooMapper;
    }

    @Transactional
    public void addFoo(Foo foo) {
        fooMapper.insertFoo(foo);
    }

    @Transactional
    public Foo findFoo(int id) {
        return fooMapper.selectFoo(id);
    }
}
