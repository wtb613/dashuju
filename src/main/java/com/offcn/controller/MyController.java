package com.offcn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping("/MyController")
    @ResponseBody
    public String run(){
        return "我能直接打印到浏览器上";
    }
}
