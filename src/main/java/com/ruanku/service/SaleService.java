package com.ruanku.service;

import com.ruanku.domain.Administrator;
import com.ruanku.domain.Sale;

import java.util.List;

public interface SaleService {

    //店铺历史销售额查询所有
    public List<Sale> FindAll();

    //根据id和金额范围查询
    public List<Sale> Query(Integer storeId,Integer MinMoney,Integer MaxMoney);

    //多店铺销售额对比-从小到大
    public List<Sale> ContrastMinToMax(Integer MinMoney,Integer MaxMoney,String StartDate,String EndDate);

    //多店铺销售额对比-从大到小
    public List<Sale> ContrastMaxToMin(Integer MinMoney,Integer MaxMoney,String StartDate,String EndDate);

    //销售额添加
    public void Add(Sale sale);

    //生成柱状图
    public List<Sale> DateView(String StartDate,String EndDate,Integer storeId);
}
