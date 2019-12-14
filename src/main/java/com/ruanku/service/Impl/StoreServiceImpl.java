package com.ruanku.service.Impl;

import com.ruanku.dao.SaleDao;
import com.ruanku.dao.StoreDao;
import com.ruanku.domain.Sale;
import com.ruanku.domain.Store;
import com.ruanku.service.SaleService;
import com.ruanku.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDao storeDao;


    //店铺查询所有
    public List<Store> FindAll() {
        return storeDao.FindAll();
    }

    @Override
    public List<Store> FindId(Integer storeId) {
        return storeDao.FindId(storeId);
    }

    @Override
    public List<Store> FindMembership(Integer membership) {
        return storeDao.FindMembership(membership);
    }

    @Override
    public List<Store> FindAdministratorId(Integer administratorId) {
        return storeDao.FindAdministratorId(administratorId);
    }

    //根据name模糊查询
    public List<Store> FindName(Integer storeId,String name) {
        if (storeId == null) {
            return storeDao.FindName(name);
        } else {
            return storeDao.FindIdName(storeId, name);
        }
    }

    //修改店铺信息
    public void Update(Store store) {
        storeDao.Update(store);
    }

    //删除店铺信息
    public void Delete(Integer storeId) {
        storeDao.Delete(storeId);
    }

    //添加店铺信息
    public void Add(Store store) {
        storeDao.Add(store);
    }
}
