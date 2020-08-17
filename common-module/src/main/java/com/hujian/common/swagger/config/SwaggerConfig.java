package com.hujian.common.swagger.config;

import io.swagger.annotations.Api;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
@ConditionalOnProperty(name = "swagger.enabled", matchIfMissing = true)@EnableSwagger2
@EnableAutoConfiguration
@Configuration
public class SwaggerConfig {

    //配置sWAgger的docket实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //是否打开Swagger   不写默认true
                .enable(true)
                //配置接口
                .select()
                //RequestHandlerSelectors  配置要扫描接口的方式
                //扫码指定的包
//                .apis(RequestHandlerSelectors.basePackage("com.hj.approvalprocess.controller"))
                //所有方法
//                .apis(RequestHandlerSelectors.any())
                //不扫描
//                .apis(RequestHandlerSelectors.none())
                //根据类上的注解
//                .apis(RequestHandlerSelectors.withClassAnnotation(UserController.class))
                //根据方法上的注解
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.any())
                //过滤信息
                .paths(PathSelectors.ant(""))
                .build();
    }


    //配置swagger信息=>apiInfo
    public ApiInfo apiInfo(){
        //作者信息
     Contact  DEFAULT_CONTACT=new Contact("胡剑","123","456");
        return new ApiInfo(
                //标题
                "胡剑的swagger文档",
                //描述信息
                "详细说明",
                //版本
                "1.0",
                //组织路径
                "https://www.baidu.com",
                //作者信息
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }

}
