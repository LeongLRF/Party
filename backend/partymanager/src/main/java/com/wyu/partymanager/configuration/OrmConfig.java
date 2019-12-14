package com.wyu.partymanager.configuration;

import core.CachedDbConnection;
import core.inerface.IDbConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import util.Model;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author Leong
 * @date 2019/11/17 12:47
 */
@Configuration
@SuppressWarnings("all")
public class OrmConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    IDbConnection dbConnection(){
        config.Configuration configuration = new config.Configuration();
        configuration.setModel(Model.POOL_MODEL);
        configuration.setEnableCache(false);
        JedisPool jedisPool = new JedisPool("59.110.171.118",6379);
         IDbConnection dbConnection = null;
        try {
             dbConnection = new CachedDbConnection(dataSource,configuration,jedisPool);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConnection;
    }
}
