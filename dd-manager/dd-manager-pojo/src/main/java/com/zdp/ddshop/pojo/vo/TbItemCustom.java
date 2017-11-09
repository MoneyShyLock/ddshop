package com.zdp.ddshop.pojo.vo;

import com.zdp.ddshop.pojo.po.TbItem;

public class TbItemCustom extends TbItem {

    private String catName;
    private String createTime;
    private String updateTime;
    private String priceView;

    public String getPriceView() {
        return priceView+"￥";
    }

    public void setPriceView(String priceView) {
        this.priceView = priceView;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
