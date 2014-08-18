package com.tatianomnom.choozorro.db;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * TODO add description
 */
public interface FooMapper {

    @Insert("INSERT INTO foo (id, name) VALUES (#{id}, #{name})")
    int insertFoo(Foo foo);

    @Select("SELECT * FROM foo WHERE id = #{id}")
    Foo selectFoo(int id);
}
