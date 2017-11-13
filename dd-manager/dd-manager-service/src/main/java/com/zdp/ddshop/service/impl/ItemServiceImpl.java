package com.zdp.ddshop.service.impl;

import com.zdp.ddshop.common.dto.Order;
import com.zdp.ddshop.common.dto.Page;
import com.zdp.ddshop.common.dto.Result;
import com.zdp.ddshop.dao.PageMapper;
import com.zdp.ddshop.dao.TbItemDescMapper;
import com.zdp.ddshop.dao.TbItemMapper;
import com.zdp.ddshop.pojo.po.TbItem;
import com.zdp.ddshop.pojo.po.TbItemDesc;
import com.zdp.ddshop.pojo.po.TbItemExample;
import com.zdp.ddshop.pojo.vo.TbItemCustom;
import com.zdp.ddshop.pojo.vo.TbItemQuery;
import com.zdp.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private PageMapper pageMapper;
    @Autowired
    private TbItemDescMapper tbItemDescMapper;


    @Override
    public TbItem getById(Long itemId) {
        return tbItemMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public Result<TbItemCustom> listItemByPage(Page page,Order order,TbItemQuery query) {
        Result<TbItemCustom> result = null;
        try {
            //创建一个实体类--响应参数
            result = new Result<TbItemCustom>();
            //得到total，并设值
            int total = pageMapper.countItems(query);

            result.setTotal(total);
            //对rows进行设值

            List<TbItemCustom> list = pageMapper.listItemsByPage(page,order,query);

            result.setRows(list);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int updateItemsById(List<Long> ids,byte state) {
        TbItem record = new TbItem();
        record.setStatus(state);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);

        return tbItemMapper.updateByExampleSelective(record, example);
    }

    @Transactional
    @Override
    public int saveItem(TbItem tbItem, String desc) {
        //将数据添加到商品表
        tbItem.setId(1L);
        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());
        tbItem.setStatus((byte)1);
        int count = tbItemMapper.insert(tbItem);

        //将数据添加到商品描述表
        TbItemDesc tbItemDesc =new TbItemDesc();
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(new Date());
        tbItemDesc.setUpdated(new Date());
        tbItemDesc.setItemId(1L);
        count=tbItemDescMapper.insert(tbItemDesc);
        return count;
    }


}
