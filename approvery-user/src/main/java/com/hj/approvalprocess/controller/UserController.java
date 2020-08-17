package com.hj.approvalprocess.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/test" )
@RestController
public class UserController {
    @ApiOperation(value = "这是value",notes = "这是notes")
    @GetMapping(value = "/hujian")
    public String hello(){
            return "测";
    }

}
