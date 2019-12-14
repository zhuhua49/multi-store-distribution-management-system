package com.ruanku.domain;

import java.io.Serializable;
import java.util.Date;

public class Sale implements Serializable {
    private int saleId;
    private Date sTime;
    private int income;
    private int storeId;
    private int orders;
    private String remarks;

    private Store store;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public Date getsTime() {
        return sTime;
    }

    public void setsTime(Date sTime) {
        this.sTime = sTime;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleId +
                ", sTime=" + sTime +
                ", income=" + income +
                ", storeId=" + storeId +
                ", orders=" + orders +
                ", remarks='" + remarks + '\'' +
                ", store=" + store +
                '}';
    }
}
