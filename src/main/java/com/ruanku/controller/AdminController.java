package com.ruanku.controller;

import com.ruanku.domain.Administrator;
import com.ruanku.domain.Member;
import com.ruanku.domain.User;
import com.ruanku.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
@SessionAttributes(names = {"Admin"},types = {Administrator.class})
public class AdminController {


    @Autowired
    private AdminService adminService;

    /**
     * 管理员登录、验证
     * @param administrator
     */
    @RequestMapping("/login")
    @ResponseBody
    public String Login(HttpSession session, Administrator administrator, Model model){
        //System.out.println("传入的值为："+administrator);
        List<Administrator> list = adminService.Login(administrator);
        //System.out.println("查询结果："+list);
        model.addAttribute("list",list);
        if (list.size()!=0) {
            Administrator Admin = new Administrator();
            Admin.setAdministratorId(list.get(0).getAdministratorId());
            Admin.setAdminName(list.get(0).getAdminName());
            Admin.setPosition(list.get(0).getPosition());
            Admin.setJurisdiction(list.get(0).getJurisdiction());
            Admin.setPhone(list.get(0).getPhone());
            Admin.setPwd(list.get(0).getPwd());
            model.addAttribute("Admin",Admin);
            session.setAttribute("adminName",list.get(0).getAdminName());
            session.setAttribute("user", new User("用户" + list.get(0).getAdminName()));
            if (list.get(0).getJurisdiction()==1){
            return "cm";
            }else {
                return "bm";
            }
        }else
            return "error";
    }

    //跳转到总店管理员中心
    @RequestMapping("/logincenter")
    public String logincenter(){
        return "admin/center";
    }

    //跳转到分店管理员中心
    @RequestMapping("/loginstorecenter")
    public String loginstorecenter(){
        return "admin/storecenter";
    }


    //清除session中的用户数据-退出登录操作
    @RequestMapping("/loginout")
    public String loginout(SessionStatus sessionStatus,HttpSession session){
        session.removeAttribute("adminName");
        sessionStatus.setComplete();
        return "admin/login";
    }



}
