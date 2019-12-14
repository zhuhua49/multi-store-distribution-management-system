package com.ruanku.service;

import com.ruanku.domain.ChartMessage;
import com.ruanku.domain.Message;

import java.util.List;

public interface ChartMessageService {

    //根据会员Id和管理员Id查询
    public List<ChartMessage> FindChartMessage(Integer memberId,Integer administratorId);

    //根据会员Id和管理员Id以及isRead查询
    public List<ChartMessage> FindMAIsRead(Integer memberId,Integer administratorId,String receiver);

    //插入发送的消息
    public void Add(ChartMessage chartMessage);

    //根据memberId和administratorId修改消息isRead为2已读状态
    public void Update(Integer memberId,Integer administratorId,String receiver);
}
