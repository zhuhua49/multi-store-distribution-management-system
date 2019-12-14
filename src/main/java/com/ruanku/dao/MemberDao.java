package com.ruanku.dao;

import com.ruanku.domain.Member;
import com.ruanku.domain.Message;
import com.ruanku.domain.Sale;
import com.ruanku.domain.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface MemberDao {


    //会员查询所有
    @Select("select * from member")
    public List<Member> FindAll();

    //根据administratorId查询会员
    @Select("select * from member where administratorId=#{administratorId}")
    public List<Member> FindAdministratorId(Integer administratorId);

    //根据memberId查询会员
    @Select("select * from member where memberId=#{memberId}")
    public List<Member> FindMemberId(Integer memberId);

    // 根据年龄范围查询
    @Select("select * from member where age between #{ageA} and #{ageB}")
    public List<Member> FindAge(@Param("ageA") Integer ageA, @Param("ageB") Integer ageB);

    // 根据年龄范围和性别查询
    @Select("select * from member where age between #{ageA} and #{ageB} and sex=#{sex} and administratorId=#{administratorId}")
    public List<Member> FindAgeAndSex(@Param("administratorId") Integer administratorId,@Param("ageA") Integer ageA, @Param("ageB") Integer ageB,@Param("sex") String sex);

    //会员登录查询验证
    @Select("select * from  member where phone=#{phone} and pwd=#{pwd}")
    public List<Member> Login(Member member);

    //会员注册
    @Insert("insert into member (name,address,phone,administratorId,core,pwd,age,sex,level) values (#{name},#{address},#{phone},#{administratorId},#{core},#{pwd},#{age},#{sex},#{level})")
    public void Register(Member member);

    //会员修改信息前根据memberId查询
    @Select("select * from  member where memberId=#{memberId}")
    public List<Member> FindId(int memberId);

    //会员根据phone查询
    @Select("select * from  member where phone=#{phone}")
    public List<Member> FindPhone(String phone);

    //会员修改信息
    @Update("update member set name=#{name},age=#{age},sex=#{sex},address=#{address},phone=#{phone} where memberId=#{memberId}")
    public void ChangeInformation(Member member);

    //管理员修改会员积分和等级信息
    @Update("update member set core=#{core},level=#{level} where memberId=#{memberId}")
    public void Updatecorelevel(Member member);

    //会员修改密码
    @Update("update member set pwd=#{pwd} where memberId=#{memberId}")
    public void ChangePassword(@Param("pwd") String pwd,@Param("memberId") int memberId);

}