package com.zdp.ddshop.dao;

import com.zdp.ddshop.common.dto.Order;
import com.zdp.ddshop.common.dto.Page;
import com.zdp.ddshop.pojo.po.TbItem;
import com.zdp.ddshop.pojo.vo.TbItemCustom;
import com.zdp.ddshop.pojo.vo.TbItemQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PageMapper {
    List<TbItem> selectAll();

    int countItems(@Param("query") TbItemQuery query);

    List<TbItemCustom> listItemsByPage(@Param("page") Page page,@Param("order") Order order,@Param("query") TbItemQuery query);
}
