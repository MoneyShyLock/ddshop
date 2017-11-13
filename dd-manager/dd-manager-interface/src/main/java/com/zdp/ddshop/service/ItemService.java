package com.zdp.ddshop.service;

import com.zdp.ddshop.common.dto.Order;
import com.zdp.ddshop.common.dto.Page;
import com.zdp.ddshop.common.dto.Result;
import com.zdp.ddshop.pojo.po.TbItem;
import com.zdp.ddshop.pojo.vo.TbItemCustom;
import com.zdp.ddshop.pojo.vo.TbItemQuery;

import java.util.List;

public interface ItemService {
    public TbItem getById(Long itemId) ;



    Result<TbItemCustom> listItemByPage(Page page,Order order,TbItemQuery query);

    int updateItemsById(List<Long> ids,byte state);

    int saveItem(TbItem tbItem, String desc);
}
