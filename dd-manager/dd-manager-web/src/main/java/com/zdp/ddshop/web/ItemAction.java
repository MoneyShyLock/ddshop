package com.zdp.ddshop.web;

import com.zdp.ddshop.common.dto.Order;
import com.zdp.ddshop.common.dto.Page;
import com.zdp.ddshop.common.dto.Result;
import com.zdp.ddshop.pojo.po.TbItem;
import com.zdp.ddshop.pojo.vo.TbItemCustom;
import com.zdp.ddshop.pojo.vo.TbItemQuery;
import com.zdp.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Scope
public class ItemAction {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
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
            items = itemService.listItemByPage(page, order, query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @ResponseBody
    @RequestMapping(value = "/items/batch", method = RequestMethod.POST)
    public int updateItemsById(@RequestParam("ids[]") List<Long> ids, @RequestParam("state") byte state) {
        int count = itemService.updateItemsById(ids, state);

        return count;
    }

    @ResponseBody
    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public int saveItem(TbItem tbItem,String content,String paramData) {
        String desc = content.replaceAll("<p>", "").replaceAll("</p>", "");
        int count = 0;
        try {
            count = itemService.saveItem(tbItem, desc);
            System.out.println(content+":"+paramData);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return count;
    }

}
