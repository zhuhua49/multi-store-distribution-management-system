package com.ruanku.service.Impl;

import com.ruanku.dao.MemberDao;
import com.ruanku.domain.Member;
import com.ruanku.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    //会员登录、校验
    public List<Member> Login(Member member) {
        return memberDao.Login(member);
    }

    //会员查询所有
    public List<Member> FindAll() {
        return memberDao.FindAll();
    }

    //根据年龄范围和性别查询
    public List<Member> FindAgeAndSex(Integer administratorId,Integer ageA, Integer ageB, String sex) {
        if (ageA==null){ageA=0;}
        if (ageB==null){ageB=100;}
        if (sex.equals("全部")){
           // System.out.println("执行了true： ageA："+ageA+"  ageB:"+ageB+"  sex:"+sex+"list:"+memberDao.FindAge(ageA,ageB));
            return memberDao.FindAge(ageA,ageB);
        }else {
            //System.out.println("执行了false： ageA："+ageA+"  ageB:"+ageB+"  sex:"+sex+"list:"+memberDao.FindAgeAndSex(ageA,ageB,sex));
            return memberDao.FindAgeAndSex(administratorId,ageA,ageB,sex);
        }
    }

    //会员注册
    public void Register(Member member) {
        member.setLevel("普通会员");
        memberDao.Register(member);
    }

    //会员修改信息前根据memberId查询
    public List<Member> FindId(int memberId) {
        return memberDao.FindId(memberId);
    }

    //根据phone查询会员
    public List<Member> FindPhone(String phone) {
        return memberDao.FindPhone(phone);
    }

    //会员修改信息
    public void ChangeInformation(Member member) {
        memberDao.ChangeInformation(member);
    }

    //会员修改密码
    public void ChangePassword(String pwd,int memberId) {
        memberDao.ChangePassword(pwd,memberId);
    }

    //修改会员等级
    public void Updatecorelevel(Member member) {
        memberDao.Updatecorelevel(member);
    }

    //查询会员所属店铺店长id
    public List<Member> FindAdministratorId(Integer administratorId) {
        return memberDao.FindAdministratorId(administratorId);
    }

    //根据memberId查询
    public List<Member> FindMemberId(Integer memberId) {
        return memberDao.FindMemberId(memberId);
    }
}
