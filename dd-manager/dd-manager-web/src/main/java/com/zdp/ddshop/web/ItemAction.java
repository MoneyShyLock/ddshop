package com.zdp.ddshop.web;

import com.zdp.ddshop.pojo.po.TbItem;
import com.zdp.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope
public class ItemAction {
    @Autowired
    private ItemService itemService;



    @ResponseBody
    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    public TbItem getById(@PathVariable("itemId") Long itemId) {

        return itemService.getById(itemId);
    }
}
