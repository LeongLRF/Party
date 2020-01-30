package com.wyu.partymanager.configuration;

import core.DefaultDbFactory;
import core.inerface.IDbConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import util.Model;

import javax.sql.DataSource;

/**
 * @author Leong
 * @date 2019/11/17 12:47
 */
@Component
@SuppressWarnings("all")
public class SimpleOrmConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    IDbConnection dbConnection(){
        config.Configuration configuration = new config.Configuration();
        configuration.setModel(Model.POOL_MODEL);
        configuration.setEnableCache(false);
        configuration.setDataSource(dataSource);
        configuration.setJedisPool(new JedisPool("59.110.171.118",6379));
        return DefaultDbFactory.getDb(configuration);
    }
}
