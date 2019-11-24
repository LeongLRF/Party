package com.wyu.partymanager.configuration;

import core.DbConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import util.Model;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author Leong
 * @date 2019/11/17 12:47
 */
@Configuration
public class OrmConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
     DbConnection dbConnection(){
        config.Configuration configuration = new config.Configuration();
        configuration.setModel(Model.POOL_MODEL);
        configuration.setEnableCache(false);
        DbConnection dbConnection = null;
        try {
             dbConnection = new DbConnection(dataSource,configuration);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConnection;
    }
}
