package com.zdp.ddshop.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
public class IndexAction {

    //跳转主界面
    @RequestMapping("/")
    public String toIndex(){
        return  "index";
    }
}
