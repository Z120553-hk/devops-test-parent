package com.example.demo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author hk
 * @Date 2020/12/11 15:12
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "demo1 -- HelloController.....";
    }
}
