package com.ruanku.domain;

import java.io.Serializable;

public class Member implements Serializable {
    private int memberId;
    private String name;
    private String address;
    private String phone;
    private int administratorId;
    private int core;
    private String pwd;
    private int age;
    private String sex;
    private String level;
    //用于发送消息右上角的消息数
    private  int messagen;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(int administratorId) {
        this.administratorId = administratorId;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getMessagen() {
        return messagen;
    }

    public void setMessagen(int messagen) {
        this.messagen = messagen;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", administratorId=" + administratorId +
                ", core=" + core +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", level='" + level + '\'' +
                ", messagen=" + messagen +
                '}';
    }
}
