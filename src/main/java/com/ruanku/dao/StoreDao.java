package com.ruanku.dao;

import com.ruanku.domain.Member;
import com.ruanku.domain.Sale;
import com.ruanku.domain.Store;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreDao {

    //根据id和name模糊查询
    @Select("select * from store where storeId=#{storeId} and name like CONCAT('%',#{name},'%')")
    public List<Store> FindIdName(@Param("storeId") Integer storeId, @Param("name") String name);

    //根据id查询店铺
    @Select("select * from store where storeId=#{storeId}")
    public List<Store> FindId(Integer storeId);

    //根据membership查询店铺
    @Select("select * from store where membership=#{membership}")
    public List<Store> FindMembership(Integer membership);

    //根据administratorId查询店铺
    @Select("select * from store where administratorId=#{administratorId}")
    public List<Store> FindAdministratorId(Integer administratorId);

    //根据name模糊查询
    @Select("select * from store where name like CONCAT('%',#{name},'%')")
    public List<Store> FindName(String name);

    //店铺查询所有
    @Select("select * from store")
    public List<Store> FindAll();

    //修改店铺信息
    @Update("update store set name=#{name},address=#{address},phone=#{phone} where storeId=#{storeId}")
    public void Update(Store store);

    //删除店铺信息
    @Delete("delete from store where storeId=#{storeId}")
    public void Delete(Integer storeId);

    // 添加店铺信息
    @Insert("insert into store (name,phone,address,administratorId,membership) values (#{name},#{phone},#{address},#{administratorId},#{membership})")
    public void Add(Store store);

}