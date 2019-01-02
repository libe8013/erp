package com.zking.erp.authority.Interceptor;

import org.springframework.web.bind.annotation.RequestMapping;

public class HelloController {

    @RequestMapping("/erp")
    public String Hello() {
        System.out.println("Hello!");
        return "success";
    }
}
