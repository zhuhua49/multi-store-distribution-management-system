package com.ruanku.dao;

import com.ruanku.domain.Administrator;
import com.ruanku.domain.Member;
import com.ruanku.domain.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {

    //管理员登录查询验证
    @Select("select * from administrator where phone=#{phone} and pwd=#{pwd}")
    public List<Administrator> Login(Administrator administrator);

    //根据administratorId查询
    @Select("select * from administrator where administratorId=#{administratorId}")
    public List<Administrator> FindAdministratorId(int administratorId);

    //修改分店管理员信息
    @Update("update administrator set adminName=#{adminName},pwd=#{pwd},phone=#{phone} where administratorId=#{administratorId}")
    public void Update(Administrator administrator);

    //添加管理员
    @Insert("insert into administrator (adminName,position,jurisdiction,phone,pwd) values (#{adminName},#{position},#{jurisdiction},#{phone},#{pwd})")
    public void Add(Administrator administrator);

    //管理员登录查询验证
    @Select("select * from administrator where phone=#{phone}")
    public List<Administrator> FindPhone(String phone);
}
