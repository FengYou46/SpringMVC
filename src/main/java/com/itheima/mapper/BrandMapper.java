package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有品牌
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * 添加
     */
    @Insert("insert tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void addBrand(Brand brand);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    /**
     * 查询数据量
     * @return
     */
    @Select("select count(*) from tb_brand")
    int selectTotalCount();

    /**
     * 通过条件查询
     * @param begin
     * @param size
     * @param brand
     * @return
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    int selecCountByCondition(@Param("brand") Brand brand);
}
