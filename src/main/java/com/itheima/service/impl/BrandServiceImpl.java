package com.itheima.service.impl;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements com.itheima.service.BrandService {

    @Override
    public List<Brand> selectAll() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectAll();

        sqlSession.close();
        return brands;
    }

    @Override
    public void addBrand(Brand brand) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.addBrand(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectByPage((currentPage - 1) * pageSize, pageSize);
        int totalCount = brandMapper.selectTotalCount();
        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setRow(brands);
        brandPageBean.setTotalCount(totalCount);

        sqlSession.close();
        return brandPageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

//        String brandName = brand.getBrandName();
//        String companyName = brand.getCompanyName();
//
//        brand.setBrandName("%"+brandName+"%");
//        brand.setBrandName("%"+companyName+"%");

        List<Brand> brands = brandMapper.selectByPageAndCondition((currentPage - 1) * pageSize, pageSize, brand);
        int count = brandMapper.selecCountByCondition(brand);
        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setRow(brands);
        brandPageBean.setTotalCount(count);
        return brandPageBean;
    }

}
