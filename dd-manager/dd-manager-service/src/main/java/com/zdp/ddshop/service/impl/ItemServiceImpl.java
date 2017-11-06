package com.zdp.ddshop.service.impl;

import com.zdp.ddshop.dao.TbItemMapper;
import com.zdp.ddshop.pojo.po.TbItem;
import com.zdp.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;
    @Override
    public TbItem getById(Long itemId) {
        return tbItemMapper.selectByPrimaryKey(itemId);
    }
}
