package com.tatianomnom.choozorro.db;

import java.util.Properties;

import com.google.inject.name.Names;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.mybatis.guice.datasource.helper.JdbcHelper;

/**
 * TODO add description
 */
public class DbModule extends MyBatisModule {

    @Override
    protected void initialize() {
        Properties myBatisProperties = new Properties();

        //TODO how to do this without JdbcHelper? e.g. i want to include full URL, but it doesn't allow me to override JDBC.url property
        install(JdbcHelper.H2_EMBEDDED);

        myBatisProperties.setProperty("mybatis.environment.id", "test");
        myBatisProperties.setProperty("JDBC.schema", "./testdb;AUTO_SERVER=TRUE");
        myBatisProperties.setProperty("JDBC.username", "sa");
        myBatisProperties.setProperty("JDBC.password", "");
        myBatisProperties.setProperty("JDBC.autoCommit", "false"); //TODO!

        Names.bindProperties(binder(), myBatisProperties);

        bindDataSourceProviderType(PooledDataSourceProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);

        addMapperClass(FooMapper.class);

        bind(FooDao.class);
    }
}
