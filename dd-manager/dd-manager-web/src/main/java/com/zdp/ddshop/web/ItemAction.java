package com.zdp.ddshop.web;

import com.zdp.ddshop.common.dto.Order;
import com.zdp.ddshop.common.dto.Page;
import com.zdp.ddshop.common.dto.Result;
import com.zdp.ddshop.pojo.po.TbItem;
import com.zdp.ddshop.pojo.vo.TbItemCustom;
import com.zdp.ddshop.pojo.vo.TbItemQuery;
import com.zdp.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ResponseBody
    @RequestMapping("/items")
    public Result<TbItemCustom> itemsList(Page page, Order order, TbItemQuery query) {

        Result<TbItemCustom> items = null;
        try {
            items = itemService.listItemByPage(page,order,query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @ResponseBody
    @RequestMapping(value="/items/batch",method = RequestMethod.POST)
    public int updateItemsById(@RequestParam("ids[]") List<Long> ids,@RequestParam("state") byte state) {
        int count=itemService.updateItemsById(ids,state);

        return count;
    }

    @ResponseBody
    @RequestMapping("/item")
    public int addItem(TbItem tbItem,String desc) {

        Result<TbItemCustom> items = null;
        try {
            items = itemService.listItemByPage(page,order,query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
}
