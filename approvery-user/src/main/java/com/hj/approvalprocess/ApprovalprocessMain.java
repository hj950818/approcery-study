package com.hj.approvalprocess;


import com.hujian.common.swagger.zhujie.EnableHJSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableHJSwagger
public class ApprovalprocessMain {
    public static void main(String[] args) {
        SpringApplication.run(ApprovalprocessMain.class,args);
    }
}
