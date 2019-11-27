package com.wyu.partymanager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.wyu.partymanager.configuration.LoginFilter;
import com.wyu.partymanager.service.sys.TokenService;
import com.wyu.partymanager.service.sys.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

import java.nio.charset.Charset;

@MapperScan("com.wyu.partymanager.mapper")
@SpringBootApplication
public class PartymanagerApplication {

    private final UserService userService;
    private final TokenService tokenService;

    public PartymanagerApplication(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PartymanagerApplication.class, args);
    }

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters(){
        FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig=new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters((HttpMessageConverter) fastConverter);
    }

    @Bean
    public FilterRegistrationBean<LoginFilter> registerFilter(){
        FilterRegistrationBean<LoginFilter> bean = new FilterRegistrationBean<>();
        bean.addUrlPatterns("/*");
        bean.setFilter(new LoginFilter(userService,tokenService));
        return bean;
    }

}
