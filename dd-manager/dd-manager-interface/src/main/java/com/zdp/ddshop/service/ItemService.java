package com.zdp.ddshop.service;

import com.zdp.ddshop.pojo.po.TbItem;

import java.util.List;

public interface ItemService {
    public TbItem getById(Long itemId) ;

    List<TbItem> selectAll();
}
