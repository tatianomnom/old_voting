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

        install(JdbcHelper.H2_EMBEDDED);

        myBatisProperties.setProperty("mybatis.environment.id", "test");
        myBatisProperties.setProperty("JDBC.schema", "./build/testdb;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1");
        myBatisProperties.setProperty("derby.create", "false"); //TODO
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
