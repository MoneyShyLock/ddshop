package com.zdp.ddshop.web;

import com.zdp.ddshop.pojo.po.TbItem;
import com.zdp.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    public ModelAndView page(@PathVariable String page) {

        ModelAndView modelAndView=new ModelAndView(page);
        if ("item-list".equals(page)) {
            List<TbItem> items = itemService.selectAll();
            modelAndView.addObject("items",items);
        }
        return modelAndView;
    }
}
