package com.zdp.ddshop.service.impl;

import com.zdp.ddshop.common.dto.TreeNode;
import com.zdp.ddshop.dao.TbItemCatMapper;
import com.zdp.ddshop.pojo.po.TbItemCat;
import com.zdp.ddshop.pojo.po.TbItemCatExample;
import com.zdp.ddshop.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService{
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public List<TreeNode> listItemCats(Long parentId) {
        //创建查询模板
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
        List<TreeNode> resultList = new ArrayList<TreeNode>();
        //遍历原有集合
        for (int i=0;i<list.size();i++){
            TreeNode node = new TreeNode();
            node.setId(list.get(i).getId());
            node.setText(list.get(i).getName());
            node.setState(list.get(i).getIsParent() ? "closed" : "open");

            resultList.add(node);
        }
        System.out.println(resultList.get(0));
        return resultList;

    }
}
