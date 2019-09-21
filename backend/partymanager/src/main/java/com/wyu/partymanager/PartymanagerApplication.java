package com.wyu.partymanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wyu.partymanager.mapper")
@SpringBootApplication
public class PartymanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PartymanagerApplication.class, args);
    }

}
