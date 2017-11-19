package com.zdp.ddshop.service;

import com.zdp.ddshop.common.dto.Page;
import com.zdp.ddshop.common.dto.Result;
import com.zdp.ddshop.pojo.po.TbItemParam;
import com.zdp.ddshop.pojo.vo.TbItemParamCustom;

public interface ItemParamService {
    Result<TbItemParamCustom> listItemByPage(Page page);

    int itemParamSave(Long cid, String paramData);

    TbItemParam getParamById(Long cid);
}
