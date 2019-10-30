package com.wyu.partymanager.service.pm;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyu.partymanager.entity.sys.Clazz;
import com.wyu.partymanager.mapper.ClazzMapper;
import com.wyu.partymanager.servicedao.ClazzServiceDao;
import org.springframework.stereotype.Service;

@Service
public class ClazzService extends ServiceImpl<ClazzMapper, Clazz> implements ClazzServiceDao {
}
