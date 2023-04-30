package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{

    private BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Brand> brands = brandService.selectAll();


        String jsonString = JSON.toJSONString(brands);

        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void addBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader bufferedReader = request.getReader();
        String params = bufferedReader.readLine();

        Brand brand = JSON.parseObject(params, Brand.class);
        brandService.addBrand(brand);

        response.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader bufferedReader = request.getReader();
        String params = bufferedReader.readLine();

        int[] ids = JSON.parseObject(params, int[].class);
        brandService.deleteByIds(ids);

        response.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        Integer currentPage = Integer.valueOf(req.getParameter("currentPage"));
        Integer pageSize = Integer.valueOf(req.getParameter("pageSize"));

        PageBean<Brand> brandPageBean = brandService.selectByPage(currentPage, pageSize);

        String jsonString = JSON.toJSONString(brandPageBean);

        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        Integer currentPage = Integer.valueOf(req.getParameter("currentPage"));
        Integer pageSize = Integer.valueOf(req.getParameter("pageSize"));

        BufferedReader bufferedReader = req.getReader();
        String params = bufferedReader.readLine();
        Brand brand = JSON.parseObject(params, Brand.class);

        PageBean<Brand> brandPageBean = brandService.selectByPageAndCondition(currentPage, pageSize, brand);

        String jsonString = JSON.toJSONString(brandPageBean);

        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

}
