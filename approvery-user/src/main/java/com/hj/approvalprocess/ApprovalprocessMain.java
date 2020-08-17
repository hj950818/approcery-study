package com.hj.approvalprocess;


import com.hujian.common.swagger.config.SwaggerConfig;
import com.hujian.common.swagger.zhujie.EnableHJSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableHJSwagger
public class ApprovalprocessMain {
    public static void main(String[] args) {
        SpringApplication.run(ApprovalprocessMain.class,args);
    }
}
