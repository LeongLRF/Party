package com.wyu.partymanager;

import com.wyu.partymanager.entity.sys.User;
import core.inerface.IDbConnection;
import core.support.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PartymanagerApplicationTests {

    @Autowired
    IDbConnection db;
    @Test
    public void insert(){
        Page<User> page = db.form(User.class).page(0,1);
        System.out.println(page);
    }
}
