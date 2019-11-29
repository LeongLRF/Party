package com.wyu.partymanager;

import com.wyu.partymanager.entity.dto.AddActivityReq;
import com.wyu.partymanager.entity.pm.TakePart;
import core.inerface.IDbConnection;
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
        AddActivityReq req = new AddActivityReq();
        db.insert(req);
        System.out.println(req.getId());
    }
}
