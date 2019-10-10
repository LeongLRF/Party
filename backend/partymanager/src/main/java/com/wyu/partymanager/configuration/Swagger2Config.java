package com.wyu.partymanager.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Leong
 * @date 2019/9/20 0:24
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .directModelSubstitute(Timestamp.class,String.class)
                .directModelSubstitute(Date.class,String.class)
                .enable(true)
                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.wyu"))
                .paths(PathSelectors.any())
                .build();
    }//PathSelectors.regex("/v1/")

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Manager Restful API")
                .description("学院项目 API")
                .version("1.0")
                .build();

    }
}
