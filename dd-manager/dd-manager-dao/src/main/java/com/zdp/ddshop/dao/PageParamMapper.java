package com.zdp.ddshop.dao;

import com.zdp.ddshop.pojo.vo.TbItemParamCustom;

import java.util.List;
import java.util.Map;

public interface PageParamMapper {
    int countItems();

    List<TbItemParamCustom> listItemsByPage(Map map);
}
