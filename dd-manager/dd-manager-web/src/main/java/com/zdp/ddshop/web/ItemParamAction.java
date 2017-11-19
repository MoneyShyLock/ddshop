package com.zdp.ddshop.web;

import com.zdp.ddshop.common.dto.Page;
import com.zdp.ddshop.common.dto.Result;
import com.zdp.ddshop.pojo.po.TbItemParam;
import com.zdp.ddshop.pojo.vo.TbItemParamCustom;
import com.zdp.ddshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope
public class ItemParamAction {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ItemParamService itemParamService;

    @ResponseBody
    @RequestMapping("/itemParams")
    public Result<TbItemParamCustom> getItemParams(Page page) {
        Result<TbItemParamCustom> params = null;
        try {
            params = itemParamService.listItemByPage(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;

    }
    @ResponseBody
    @RequestMapping("/item/param/save/{cid}")
    public int paramItemSave(@PathVariable("cid") Long cid, String paramData) {
        int count=0;
        try {
            count=itemParamService.itemParamSave(cid,paramData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;

    }
    @ResponseBody
    @RequestMapping(value = "itemParam/query/{cid}",method = RequestMethod.GET )
    public TbItemParam getParamById(@PathVariable("cid") Long cid) {
        TbItemParam tbItemParam=null;
        try {
            tbItemParam=itemParamService.getParamById(cid);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbItemParam;

    }

}
