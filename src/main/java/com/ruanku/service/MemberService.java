package com.ruanku.service;

import com.ruanku.domain.Member;

import java.util.List;

public interface MemberService {

    //会员登录查询
    public List<Member> Login(Member member);

    //会员查询所有
    public List<Member> FindAll();

    //根据年龄范围和性别查询
    public List<Member> FindAgeAndSex(Integer administratorId,Integer ageA,Integer ageB,String sex);

    //会员注册
    public void Register(Member member);

    //会员修改信息前根据memberId查询
    public List<Member> FindId(int memberId);

    //根据phone查询
    public List<Member> FindPhone(String phone);

    //会员修改信息
    public void ChangeInformation(Member member);

    //会员修改密码
    public void ChangePassword(String pwd,int memberId);

    //管理员修改会员积分和等级信息
    public void Updatecorelevel(Member member);

    //根据administratorId查询会员
    public List<Member> FindAdministratorId(Integer administratorId);

    //根据memberId查询会员
    public List<Member> FindMemberId(Integer memberId);
}
