package com.itheima.pojo;

import java.util.List;

public class PageBean<T> {

    private int totalCount;

    //当前页数据
    private List<T> row;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRow() {
        return row;
    }

    public void setRow(List<T> row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", row=" + row +
                '}';
    }
}
