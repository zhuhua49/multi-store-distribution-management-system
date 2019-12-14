package com.ruanku.controller;


import com.ruanku.domain.Administrator;
import com.ruanku.domain.Sale;
import com.ruanku.domain.Store;
import com.ruanku.service.SaleService;
import com.ruanku.service.StoreService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sale")
@SessionAttributes(names = {"Admin"},types = {Administrator.class})
public class SaleController {

    @Autowired
    private SaleService saleService;
    @Autowired
    private StoreService storeService;

    /**
    //跳转到店铺历史销售额查询
    @RequestMapping("jumpsquery")
    public String jumpsquery(Model model){
        System.out.println("已经执行jumpsquery");
        List<Sale> list = saleService.FindAll();
        List<Store> list1 = storeService.FindAll();
        System.out.println("list的值为："+list);
        System.out.println("list1的值为："+list1);
        for (int i=0;i<list.size();i++){
        list.get(i).setStore(list1.get(i));
        }
        model.addAttribute("list",list);
        System.out.println("jumpsquery查询结果为："+list);
        return "admin/sales/query";
    }
    */

    //跳转到店铺历史销售额查询
    @RequestMapping("/jumpsquery")
    public String jumpsquery(@ModelAttribute("Admin") Administrator Admin,Model model){
        model.addAttribute("Admin",Admin);
        if (Admin.getJurisdiction()==2){
            List<Store> list1 = storeService.FindAdministratorId(Admin.getAdministratorId());
            model.addAttribute("qstoreId",list1.get(0).getStoreId());
            model.addAttribute("qname",list1.get(0).getName());
            model.addAttribute("list1",list1);
            return "admin/sales/storequery";
        }
        return "admin/sales/query";
    }

    //跳转到分店铺自身历史销售额查询
    @RequestMapping("/jumpstorequery")
    public String jumpstorequery(@ModelAttribute("Admin") Administrator Admin,Model model){
        model.addAttribute("Admin",Admin);
        if (Admin.getJurisdiction()==2){
            List<Store> list1 = storeService.FindAdministratorId(Admin.getAdministratorId());
            model.addAttribute("qstoreId",list1.get(0).getStoreId());
            model.addAttribute("qname",list1.get(0).getName());
            model.addAttribute("list1",list1);
            return "admin/sales/storequery";
        }
        return "admin/sales/storequery";
    }

    /**
    //跳转到分店铺自身历史销售额查询
    @RequestMapping("/jumpstorequery")
    public String jumpstorequery(@ModelAttribute("Admin") Administrator Admin,Model model){
        model.addAttribute("Admin",Admin);
        return "admin/sales/storequery";
    }
    */

    //跳转到多店铺销售额对比查询
    @RequestMapping("/jumpcontrast")
    public String jumpcontrast(){
        return "admin/sales/contrast";
    }

    //跳转到店铺管理查询
    @RequestMapping("/jumpmquery")
    public String jumpmquery(){
        return "admin/sales/query";
    }

    //跳转到店铺销售额添加页面
    @RequestMapping("/jumpadd")
    public String jumpadd(){
        return "admin/sales/add";
    }

    //跳转到店铺销售额添加页面-分店
    @RequestMapping("/jumpstoreadd")
    public String jumpstoreadd(){
        return "admin/sales/storeadd";
    }

    //跳转到店铺销售额柱状图
    @RequestMapping("/jumpdateview")
    public String jumpdateview(Integer storeId,Model model){
        List<Store> list = storeService.FindId(storeId);
        model.addAttribute("list",list);
        return "admin/sales/dateview";
    }

    //跳转到分店铺销售额柱状图
    @RequestMapping("/jumpstoredateview")
    public String jumpstoredateview(Integer storeId,Model model){
        List<Store> list = storeService.FindId(storeId);
        model.addAttribute("list",list);
        return "admin/sales/storedateview";
    }
/**
 * 测试
    @Test
    public void test(){
        Date date = new Date();
        ArrayList list = new ArrayList();
        list.add(date);
        list.add("hhha");
        list.add(123);
        date = (Date) list.get(0);
        DateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
        System.out.println("时间为："+date);
        System.out.println("list时间为："+list);
    }
*/
    //柱状图
    @RequestMapping("/dateview")
    public String dateview(String StartDate, String EndDate,Integer storeId,Model model){
        List<Store> list = storeService.FindId(storeId);
        List<Sale> list1 = saleService.DateView(StartDate,EndDate,storeId);
        ArrayList listMoney = new ArrayList();
        ArrayList listDate = new ArrayList();
        DateFormat sdf= new SimpleDateFormat("dd");
        for (int i=0;i<list1.size();i++){
            listMoney.add(list1.get(i).getIncome());
            listDate.add(sdf.format((Date) list1.get(i).getsTime()));
        }
        System.out.println("listMoney为："+listMoney);
        System.out.println("listDate为："+listDate);
        model.addAttribute("list",list);
        model.addAttribute("listMoney",listMoney);
        model.addAttribute("listDate",listDate);
        model.addAttribute("StartDate",StartDate);
        model.addAttribute("EndDate",EndDate);
        return "admin/sales/dateview";
    }

    //店铺历史销售额查询
    @RequestMapping("/query")
    public ModelAndView query(@ModelAttribute("Admin") Administrator Admin, Integer storeId, String name, Integer minmoney, Integer maxmoney){
        // System.out.println("已经执行：storeId :"+storeId+" name:"+name+" money"+minmoney+" maxmoney"+maxmoney);
        List<Sale> list = saleService.Query(storeId,minmoney,maxmoney);
        List<Store> list1 = null;
        if (storeId==null&&name==null){
            list1 = storeService.FindAll();

        }else {
            list1 = storeService.FindName(storeId, name);
        }
        //System.out.println("list的值为："+list);
        //System.out.println("list1的值为："+list1);
        //System.out.println("合并后的list为："+list);
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",list);
        mv.addObject("list1",list1);
        mv.addObject("qstoreId",storeId);
        mv.addObject("qname",name);
        mv.addObject("minmoney",minmoney);
        mv.addObject("maxmoney",maxmoney);
        mv.addObject("Admin",Admin);
        mv.setViewName("admin/sales/query");
        return mv;
    }
    //分店铺自身历史销售额查询
    @RequestMapping("/storequery")
    public ModelAndView storequery(@ModelAttribute("Admin") Administrator Admin, Integer minmoney, Integer maxmoney){
        System.out.println("已经执行storequery：Admin :"+Admin+" money"+minmoney+" maxmoney"+maxmoney);
        List<Sale> list = saleService.Query(null,minmoney,maxmoney);
        System.out.println("storequery中list为："+list);
        List<Store> list1 = storeService.FindAdministratorId(Admin.getAdministratorId());
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",list);
        mv.addObject("list1",list1);
        mv.addObject("qstoreId",list1.get(0).getStoreId());
        mv.addObject("qname",list1.get(0).getName());
        mv.addObject("minmoney",minmoney);
        mv.addObject("maxmoney",maxmoney);
        mv.setViewName("admin/sales/storequery");
        return mv;
    }

    //多店铺销售额对比-从小到大
    @RequestMapping("/contrastmintomax")
    public ModelAndView contrastmintomax(@ModelAttribute("Admin") Administrator Admin,Integer MinMoney,Integer MaxMoney,String StartDate, String EndDate){
        System.out.println("输入数据为： MinMoney："+MinMoney+"   MaxMoney:"+MaxMoney+"   StartDate:"+StartDate+"   EndDate:"+EndDate);
        ModelAndView mv = new ModelAndView();
        List<Store> list1 = storeService.FindMembership(Admin.getAdministratorId());
        List<Sale> list = saleService.ContrastMinToMax(MinMoney,MaxMoney,StartDate,EndDate);
        System.out.println("从小到大查询结果："+list);
        mv.addObject("list",list);
        mv.addObject("list1",list1);
        mv.addObject("MinMoney",MinMoney);
        mv.addObject("MaxMoney",MaxMoney);
        mv.addObject("StartDate",StartDate);
        mv.addObject("EndDate",EndDate);
        mv.setViewName("admin/sales/contrast");
        return mv;
    }

    //多店铺销售额对比-从大到小
    @RequestMapping("/contrastmaxtomin")
    public ModelAndView contrastmaxtomin(@ModelAttribute("Admin") Administrator Admin,Integer MinMoney,Integer MaxMoney,String StartDate, String EndDate){
        ModelAndView mv = new ModelAndView();
        List<Store> list1 = storeService.FindMembership(Admin.getAdministratorId());
        List<Sale> list = saleService.ContrastMaxToMin(MinMoney,MaxMoney,StartDate,EndDate);
        System.out.println("从大到小查询结果："+list);
        mv.addObject("list",list);
        mv.addObject("list1",list1);
        mv.addObject("MinMoney",MinMoney);
        mv.addObject("MaxMoney",MaxMoney);
        mv.addObject("StartDate",StartDate);
        mv.addObject("EndDate",EndDate);
        mv.setViewName("admin/sales/contrast");
        return mv;
    }

    //店铺销售额添加
    @RequestMapping("/saleadd")
    public String saleadd(@ModelAttribute("Admin") Administrator Admin,Sale sale){
        List<Store> list = storeService.FindAdministratorId(Admin.getAdministratorId());
        sale.setStoreId(list.get(0).getStoreId());
        sale.setsTime(new Date());
        saleService.Add(sale);
        return "admin/sales/add";
    }

    //分店铺店铺销售额添加
    @RequestMapping("/storesaleadd")
    public String storesaleadd(@ModelAttribute("Admin") Administrator Admin,Sale sale){
        List<Store> list = storeService.FindAdministratorId(Admin.getAdministratorId());
        sale.setStoreId(list.get(0).getStoreId());
        sale.setsTime(new Date());
        saleService.Add(sale);
        return "admin/sales/storeadd";
    }
}
