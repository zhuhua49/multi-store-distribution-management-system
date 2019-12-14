package com.ruanku.service.Impl;

import com.ruanku.dao.AdminDao;
import com.ruanku.domain.Administrator;
import com.ruanku.domain.Member;
import com.ruanku.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    //管理员登录、校验
    public List<Administrator> Login(Administrator administrator) {
        return adminDao.Login(administrator);
    }

    //管理员添加
    public void Add(Administrator administrator) {
        adminDao.Add(administrator);
    }

    //根据电话查询
    public List<Administrator> FindPhone(String phone) {
        return adminDao.FindPhone(phone);
    }

    //根据administratorId查询分店管理员
    public List<Administrator> FindAdministratorId(int administratorId) {
        return adminDao.FindAdministratorId(administratorId);
    }

    //修改分店管理员信息
    public void Update(Administrator administrator) {
        adminDao.Update(administrator);
    }
}
