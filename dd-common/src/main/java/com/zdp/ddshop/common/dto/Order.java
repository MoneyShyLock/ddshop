package com.zdp.ddshop.common.dto;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String sort;
    private String order;


    public List<String> getOrderParams() {
        String[] sorts = this.sort.split(",");
        String[] orders = this.order.split(",");
        List<String> temp=new ArrayList<>();
        for (int i=0;i<sorts.length;i++){

             temp.add(sorts[i]+ " " + orders[i]);
        }
        return temp;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
