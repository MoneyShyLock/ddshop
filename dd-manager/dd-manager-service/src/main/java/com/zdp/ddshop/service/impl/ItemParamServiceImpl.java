package com.zdp.ddshop.service.impl;

import com.zdp.ddshop.common.dto.Page;
import com.zdp.ddshop.common.dto.Result;
import com.zdp.ddshop.dao.PageParamMapper;
import com.zdp.ddshop.dao.TbItemParamMapper;
import com.zdp.ddshop.pojo.po.TbItemParam;
import com.zdp.ddshop.pojo.po.TbItemParamExample;
import com.zdp.ddshop.pojo.vo.TbItemParamCustom;
import com.zdp.ddshop.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class ItemParamServiceImpl implements ItemParamService {
    @Autowired
    private PageParamMapper pageParamMapper;
    @Autowired
    private TbItemParamMapper tbItemParamMapper;

    @Override
    public Result<TbItemParamCustom> listItemByPage(Page page) {
        Result<TbItemParamCustom> result = null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("page", page);
            //创建一个实体类--响应参数
            result = new Result<TbItemParamCustom>();
            //得到total，并设值
            int total = pageParamMapper.countItems();

            result.setTotal(total);
            //对rows进行设值

            List<TbItemParamCustom> list = pageParamMapper.listItemsByPage(map);
            System.out.println(list);
            result.setRows(list);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int itemParamSave(Long cid, String paramData) {
        int count=0;
        try {
            TbItemParam tbItemParam= new TbItemParam();
            tbItemParam.setItemCatId(cid);
            tbItemParam.setParamData(paramData);
            tbItemParam.setCreated(new Date());
            tbItemParam.setUpdated(new Date());
            count=tbItemParamMapper.insert(tbItemParam);


        } catch (Exception e) {

            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public TbItemParam getParamById(Long cid) {
        TbItemParam tbItemParam=null;
        try {
            //创建查询模版
            TbItemParamExample tbItemParamExample=new TbItemParamExample();
            TbItemParamExample.Criteria criteria=tbItemParamExample.createCriteria();
            criteria.andItemCatIdEqualTo(cid);
            //执行查询
            List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(tbItemParamExample);
            if(list!=null&&list.size()>0){
                tbItemParam=list.get(0);
            }
        }catch (Exception e){

            e.printStackTrace();
        }
        return tbItemParam;
    }
}
