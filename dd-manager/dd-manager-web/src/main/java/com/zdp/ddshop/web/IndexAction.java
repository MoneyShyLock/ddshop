package com.zdp.ddshop.web;

import com.zdp.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
public class IndexAction {
    @Autowired
    private ItemService itemService;

    //跳转主界面
    @RequestMapping("/")
    public String toIndex() {
        return "index";
    }

    //跳转页面
    @RequestMapping("/{page}")
    public String page(@PathVariable String page) {

        return page;
    }
}
