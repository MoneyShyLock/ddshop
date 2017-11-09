package com.zdp.ddshop.common.dto;


/**
 * 封装分页请求的参数类
 */
public class Page {
    //当前页
    private int page;

    //每页显示的记录数
    private int rows;
    //偏移量
   // private int offset;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getOffset() {
        return (page-1)*rows;
    }


}
