package com.wyu.partymanager.service.sys;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyu.partymanager.entity.sys.Token;
import com.wyu.partymanager.mapper.TokenMapper;
import com.wyu.partymanager.servicedao.TokenServiceDao;
import org.springframework.stereotype.Service;

@Service
public class TokenService extends ServiceImpl<TokenMapper, Token> implements TokenServiceDao {
}
