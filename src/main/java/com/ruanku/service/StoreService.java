package com.ruanku.service;

import com.ruanku.domain.Sale;
import com.ruanku.domain.Store;


import java.util.List;

public interface StoreService {

    //店铺查询所有
    public List<Store> FindAll();

    //根据Id查询
    public List<Store> FindId(Integer storeId);

    //根据membership查询
    public List<Store> FindMembership(Integer membership);

    //根据administratorId查询
    public List<Store> FindAdministratorId(Integer administratorId);

    // 根据id和name模糊查询账户
    public List<Store> FindName(Integer storeId,String name);

    //修改店铺信息
    public void Update(Store store);

    //删除店铺信息
    public void Delete(Integer storeId);

    //添加店铺信息
    public void Add(Store store);

}
