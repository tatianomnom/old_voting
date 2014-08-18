package com.tatianomnom.choozorro.db;

import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

/**
 * TODO add description
 */
public interface FooMapper {

    @Insert("insert into FOO (id, name) values(#{id}, #{name})")
    int insertFoo(Foo foo);

    @Select("SELECT * FROM FOO WHERE id = #{id}")
    @ConstructorArgs
    Foo selectFoo(int id);
}
