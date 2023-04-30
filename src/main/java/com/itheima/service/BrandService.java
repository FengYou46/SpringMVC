package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;

import java.util.List;

public interface BrandService {

    List<Brand> selectAll();

    void addBrand(Brand brand);

    void deleteByIds(int[] ids);

    PageBean<Brand> selectByPage(int currentPage,int pageSize);

    PageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand);
}
