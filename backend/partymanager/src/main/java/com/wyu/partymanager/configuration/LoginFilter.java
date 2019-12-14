package com.wyu.partymanager.configuration;

import com.alibaba.fastjson.JSON;
import com.wyu.partymanager.entity.sys.Token;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.service.sys.TokenService;
import com.wyu.partymanager.service.sys.UserService;
import com.wyu.partymanager.utils.Common;
import com.wyu.partymanager.utils.Result;
import com.wyu.partymanager.utils.StringUtil;
import core.inerface.IDbConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author Leong
 * @date 2019/9/23 0:17
 */

public class LoginFilter implements Filter {
    private IDbConnection db;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
    }
    public LoginFilter(IDbConnection db){
        this.db = db;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub

        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        String origin = req.getHeader("Origin");
        if (!org.springframework.util.StringUtils.isEmpty(origin)) {
            //带cookie的时候，origin必须是全匹配，不能使用*
            res.addHeader("Access-Control-Allow-Origin", origin);
        }
        res.addHeader("Access-Control-Allow-Methods", "*");
        String headers = req.getHeader("Access-Control-Request-Headers");
        // 支持所有自定义头
        if (!org.springframework.util.StringUtils.isEmpty(headers)) {
            res.addHeader("Access-Control-Allow-Headers", headers);
        }
        // enable cookie
        res.addHeader("Access-Control-Allow-Credentials", "true");
        if (req.getMethod().equals(RequestMethod.OPTIONS.name())) {
            //防止乱码，适用于传输JSON数据
            res.setHeader("Content-Type", "application/json;charset=UTF-8");
            res.setStatus(HttpStatus.OK.value());
            return;
        }
        logger.info("请求API: " + req.getRequestURI());
        if ("/sys/login".equals(req.getRequestURI())) {
            chain.doFilter(request, response);
        } else {
            String token = getCookie("token", req).orElse("");
            Token userToken = db.getById(Token.class, token);
            if (userToken == null) {
                response.setCharacterEncoding("UTF-8");
                response.getWriter().println(JSON.toJSONString(Result.error("未登录")));
            } else {
                User user = db.getById(User.class, userToken.getUserId());
                req.getSession().setAttribute(Common.CURRENT_USER, user);
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    private Optional<String> getCookie(String name, HttpServletRequest request) {
        return Optional.ofNullable(request.getCookies())
                .flatMap(p -> Arrays.stream(p).filter(it -> it.getName().equals(name)).findFirst())
                .flatMap(p -> StringUtil.maybe(p.getValue()));
    }
}
