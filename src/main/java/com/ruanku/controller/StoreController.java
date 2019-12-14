package com.ruanku.controller;

import com.ruanku.domain.Administrator;
import com.ruanku.domain.Store;
import com.ruanku.service.AdminService;
import com.ruanku.service.StoreService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/store")
@SessionAttributes(names = {"Admin"},types = {Administrator.class})
public class StoreController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private AdminService adminService;

    //跳转店铺管理
    @RequestMapping("/jumpmquery")
    public String jumpmquery(@ModelAttribute("Admin") Administrator Admin,Model model){
       // System.out.println("session中出来的值为："+Admin);
        List<Store> list = storeService.FindAll();
        List<Store> list1 = storeService.FindMembership(Admin.getAdministratorId());
       // System.out.println("跳转结果为："+list);
        model.addAttribute("list",list);
        model.addAttribute("list1",list1);
        return "admin/manage/query";
    }

    //根据name模糊查询店铺
    @RequestMapping("/querystore")
    public ModelAndView querystore(@ModelAttribute("Admin") Administrator Admin,String name){
        ModelAndView mv = new ModelAndView();
        List<Store> list = storeService.FindName(null,name);
        List<Store> list1 = storeService.FindMembership(Admin.getAdministratorId());
        System.out.println("查询结果为："+list);
        mv.addObject("list",list);
        mv.addObject("list1",list1);
        mv.addObject("qname",name);
        mv.setViewName("admin/manage/query");
        return mv;
    }

    //跳转修改店铺信息
    @RequestMapping("/jumpupdate")
    public String jumpupdate(Integer storeId,Model model){
        List<Store> list = storeService.FindId(storeId);
        List<Administrator> list1 = adminService.FindAdministratorId(list.get(0).getAdministratorId());
       // System.out.println("跳转修改信息页结果："+list);
        model.addAttribute("list1",list1);
        model.addAttribute("list",list);
        return "admin/manage/revise";
    }

    //修改店铺信息
    @RequestMapping("/update")
    public String update(Store store,String adminname,String adminphone,String pwd){
        storeService.Update(store);
        List<Store> list = storeService.FindId(store.getStoreId());
        Administrator administrator = new Administrator();
        administrator.setAdminName(adminname);
        administrator.setPhone(adminphone);
        administrator.setPwd(pwd);
        administrator.setAdministratorId(list.get(0).getAdministratorId());
        adminService.Update(administrator);
        System.out.println("返回account"+store);
        return "redirect:/store/jumpmquery";
    }

    //删除店铺信息
    @RequestMapping("/delete")
    public String delete(Integer storeId){
        storeService.Delete(storeId);
        return "redirect:/store/jumpmquery";
    }

    //跳转添加店铺信息
    @RequestMapping("/jumpadd")
    public String jumpadd(){
        return "admin/manage/add";
    }

    //添加店铺信息
    @RequestMapping("/add")
    public String add(@ModelAttribute("Admin") Administrator Admin,Store store,String adminname,String adminphone,String pwd){
        System.out.println("已经执行添加方法");
        Administrator administrator = new Administrator();
        administrator.setAdminName(adminname);
        administrator.setPhone(adminphone);
        administrator.setPwd(pwd);
        administrator.setJurisdiction(2);
        administrator.setPosition("分店管理员");
        System.out.println("administrator的值为："+administrator);
        adminService.Add(administrator);
        List<Administrator> list = adminService.FindPhone(adminphone);
        store.setMembership(Admin.getAdministratorId());
        store.setAdministratorId(list.get(0).getAdministratorId());
       // System.out.println("session中出来的值为："+Admin);
       // System.out.println("session赋值后的store："+store);
        System.out.println("store的值为："+store);
        storeService.Add(store);
        return "redirect:/store/jumpmquery";
    }

}
