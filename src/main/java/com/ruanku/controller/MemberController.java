package com.ruanku.controller;

import com.ruanku.domain.*;
import com.ruanku.service.Impl.MemberServiceImpl;
import com.ruanku.service.MemberService;
import com.ruanku.service.MessageService;
import com.ruanku.service.StoreService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


import javax.naming.Name;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/member")
@SessionAttributes(names = {"Name","MemberId","Msgnumber"},types = {String.class,Integer.class,Integer.class})
public class MemberController {

   @Autowired
   private StoreService storeService;

   @Autowired
   private MessageService messageService;

    @Autowired
    private MemberService memberService;
    //全局变量，用作登录校验错误后重新填写跳转传对象数据
    private Member member;
/**
    @RequestMapping("/login")
    public String Login(Member member,Model model){
        List<Member> list = memberService.Login(member);
        //ModelAndView mv = new ModelAndView();
        System.out.println("查询结果："+list);
        model.addAttribute("list",list);
        //mv.addObject("list",list);
        if (list.size()!=0) {
            return "member/center";
        }else
            return "member/login";

    }
*/
    /**
     * 会员登录、验证
     * @param member
     */
    @RequestMapping("/login")
    @ResponseBody
    public String Login(HttpSession session, Member member, Model model){
        List<Member> list = memberService.Login(member);
        this.member = member;
       // System.out.println("查询结果："+list);
        //System.out.println("数组中的密码为："+list.get(0).getPwd());
        model.addAttribute("list",list);
        //存入session
        if (list.size()!=0) {
            model.addAttribute("Name",list.get(0).getName());
            model.addAttribute("MemberId",list.get(0).getMemberId());
            session.setAttribute("memberName",list.get(0).getName());
            session.setAttribute("user", new User("用户" + list.get(0).getName()));
            return "success";
        }else
            return "error";
    }

    /**
     * 登录校验成功后，跳转到member/center.jsp页面并且返回查询结果
     * 调用login中查询的member对象。json无法重定向
     * @param model
     * @return
     */
    @RequestMapping("/logincenter")
    public String center(@ModelAttribute("MemberId") Integer MemberId, Model model){
       Member member = this.member;
        List<Member> list = memberService.Login(member);
        Message message = new Message();
        message.setIsRead(1);
        message.setMemberId(MemberId);
        List<Message> list1 = messageService.FindMemberIdIsRead(message);
        System.out.println("查询输入memberId："+MemberId+"   isRead:"+message.getIsRead());
        System.out.println("list1的结果为："+list1.size()+"   "+list1);
        model.addAttribute("Msgnumber",list1.size());
        model.addAttribute("list",list);
        return "member/center";
    }

    /**
     * 登录页面跳转该方法，到注册页面
     * @return
     */
    @RequestMapping("/changeregister")
    public String changeregister(){
        return "member/register";
    }

    //跳转会员积分和等级页面
    @RequestMapping("/jumpcorelevel")
    public String jumpcorelevel(){
        return "admin/corelevel/query";
    }


    /**
     * 会员注册
     * @param member
     * @return
     */
    @RequestMapping("/register")
    public String register(Member member){
        System.out.println("注册信息："+member);
        memberService.Register(member);
        return "member/login";
    }

    /**
     * 会员修改信息前查询个人信息、跳转到修改页面
     */
    @RequestMapping("/findci")
    public ModelAndView findci(int memberId){
        ModelAndView mv = new ModelAndView();
        List<Member> list = memberService.FindId(memberId);
        mv.addObject("list",list);
        mv.setViewName("member/changeInformation");
        return mv;
    }

    /**
     * 根据Phone查询会员
     */
    @RequestMapping("/findphone")
    public ModelAndView findphone(String phone){
        ModelAndView mv = new ModelAndView();
        List<Member> list = memberService.FindPhone(phone);
        List<Store> list1 = storeService.FindAdministratorId(list.get(0).getAdministratorId());
        mv.addObject("list1",list1);
        mv.addObject("list",list);
        System.out.println("查询结果list为："+list);
        System.out.println("查询结果list1为："+list1);
        mv.addObject("phone",phone);
        mv.setViewName("admin/corelevel/query");
        return mv;
    }

    /**
     * 会员积分及等级修改
     */
    @RequestMapping("/membermage")
    public ModelAndView membermage(Member member){
        ModelAndView mv = new ModelAndView();
        System.out.println("输入的member为："+member);
        memberService.Updatecorelevel(member);
        mv.setViewName("admin/corelevel/query");
        return mv;
    }


    /**
     * 会员修改信息
     */
    @RequestMapping("/changeInformation")
    public ModelAndView changeInformation(Member member){
        ModelAndView mv = new ModelAndView();
        memberService.ChangeInformation(member);
        List<Member> list = memberService.FindId(member.getMemberId());
        mv.addObject("list",list);
        mv.setViewName("member/center");
        return mv;
    }

    /**
     * 会员点击修改密码跳转页面
     */
    @RequestMapping("/findcp")
    public ModelAndView findcp(int memberId){
        ModelAndView mv = new ModelAndView();
        List<Member> list = memberService.FindId(memberId);
        mv.addObject("list",list);
        mv.setViewName("member/changePassword");
        return mv;
    }


    /**
     * 会员修密码
     */
    @RequestMapping("/changePassword")
    public ModelAndView changePassword(int memberId, String pwd, String pwdnew){
        System.out.println("传入的值为：memberId:"+memberId+" pwd:"+pwd+" pwdnew:"+pwdnew);
        int memberid = memberId;
        ModelAndView mv = new ModelAndView();
        List<Member> list = memberService.FindId(memberId);
        //System.out.println(list.get(0).getPwd());
        //旧密码校验错误
        if (!list.get(0).getPwd().equals(pwd)){
           // System.out.println("密码错误!!");
            mv.addObject("list",list);
            mv.addObject("msg","密码错误");
            mv.addObject("memberId",memberId);
            mv.addObject("oldpwd",pwd);
            mv.addObject("pwdnew",pwdnew);
            mv.setViewName("member/changePassword");
        }
        else {
            System.out.println("memberId的值为："+memberId);
            memberService.ChangePassword(pwdnew,memberId);
            List<Member> list1 = memberService.FindId(memberid);
            mv.addObject("list",list1);
            System.out.println("新密码为："+pwdnew);
            mv.setViewName("member/center");
        }
        return mv;
    }
    //清除session中的用户数据-退出登录操作
    @RequestMapping("/loginout")
    public String loginout(SessionStatus sessionStatus,HttpSession session){
        sessionStatus.setComplete();
        session.removeAttribute("memberName");
        //System.out.println("已经移除session：");
        return "member/login";
    }

}
