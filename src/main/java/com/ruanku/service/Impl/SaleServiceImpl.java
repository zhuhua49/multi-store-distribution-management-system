package com.ruanku.service.Impl;

import com.ruanku.dao.AdminDao;
import com.ruanku.dao.SaleDao;
import com.ruanku.domain.Administrator;
import com.ruanku.domain.Sale;
import com.ruanku.service.AdminService;
import com.ruanku.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDao saleDao;


    //店铺历史销售额查询所有
    @Override
    public List<Sale> FindAll() {
        return saleDao.FindAll();
    }

    //根据id和金额范围查询
    public List<Sale> Query(Integer storeId, Integer MinMoney, Integer MaxMoney) {
        if (MinMoney==null){MinMoney = -999999999;}
        if (MaxMoney==null){MaxMoney =  999999999;}
        if (storeId==null){
            return saleDao.Queryc(MinMoney,MaxMoney);
        }
        return saleDao.Query(storeId,MinMoney,MaxMoney);
    }

    //多店铺销售额对比-从小到大
    public List<Sale> ContrastMinToMax(Integer MinMoney, Integer MaxMoney, String StartDate, String EndDate) {
        if (MinMoney==null){MinMoney = -999999999;}
        if (MaxMoney==null){MaxMoney =  999999999;}
        if (StartDate==""){StartDate ="1949-10-01";}
        if (EndDate==""){EndDate ="2049-10-01";}
        System.out.println("业务层输入结果： MinMoney："+MinMoney+"   MaxMoney:"+MaxMoney+"   StartDate:"+StartDate+"   EndDate:"+EndDate);
        return saleDao.ContrastMinToMax(MinMoney,MaxMoney,StartDate,EndDate);
    }

    //多店铺销售额对比-从大到小
    public List<Sale> ContrastMaxToMin(Integer MinMoney, Integer MaxMoney, String StartDate, String EndDate) {
        if (MinMoney==null){MinMoney = -999999999;}
        if (MaxMoney==null){MaxMoney =  999999999;}
        if (StartDate==""){StartDate ="1949-10-01";}
        if (EndDate==""){EndDate ="2049-10-01";}
        return saleDao.ContrastMaxToMin(MinMoney,MaxMoney,StartDate,EndDate);
    }

    //店铺销售额添加
    public void Add(Sale sale) {
        saleDao.Add(sale);
    }

    //生成柱状图
    public List<Sale> DateView(String StartDate, String EndDate,Integer storeId) {
        return saleDao.DateView(StartDate,EndDate,storeId);
    }


}
