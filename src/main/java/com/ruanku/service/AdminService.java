package com.ruanku.service;

import com.ruanku.domain.Administrator;
import com.ruanku.domain.Member;

import java.util.List;

public interface AdminService {

    //管理员登录查询
    public List<Administrator> Login(Administrator administrator);

    //管理员添加
    public void Add(Administrator administrator);

    //根据电话查询
    public List<Administrator> FindPhone(String phone);

    //根据administratorId查询
    public List<Administrator> FindAdministratorId(int administratorId);

    //修改分店管理员信息
    public void Update(Administrator administrator);
 }
