package com.zdp.ddshop.service.impl;

import com.zdp.ddshop.dao.PageMapper;
import com.zdp.ddshop.dao.TbItemMapper;
import com.zdp.ddshop.pojo.po.TbItem;
import com.zdp.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private PageMapper pageMapper;


    @Override
    public TbItem getById(Long itemId) {
        return tbItemMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public List<TbItem> selectAll() {
        return  pageMapper.selectAll();
    }
}
