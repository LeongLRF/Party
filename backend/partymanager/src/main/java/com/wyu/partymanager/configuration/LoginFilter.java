package com.wyu.partymanager.configuration;

import com.alibaba.fastjson.JSON;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.utils.Common;
import com.wyu.partymanager.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Leong
 * @date 2019/9/23 0:17
 */
public class LoginFilter implements Filter
{
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
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
        // region
        User user = (User) req.getSession().getAttribute(Common.CURRENT_USER);
        String str = req.getRequestURI();
        // endregion
//        res.sendError(9999, JSON.toJSONString(Result.error("未登陆")));
//        if (!str.equals("/sys/login")&&user==null){
//            res.setCharacterEncoding("UTF-8");
//            res.getWriter().write(JSON.toJSONString(Result.error("未登陆")));
//        } else {
            logger.info("request url:"+str);
            chain.doFilter(request, response);
//        }
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }
}
