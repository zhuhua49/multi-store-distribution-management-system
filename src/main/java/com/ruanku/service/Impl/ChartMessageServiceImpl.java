package com.ruanku.service.Impl;

import com.ruanku.dao.ChartMessageDao;
import com.ruanku.dao.MessageDao;
import com.ruanku.domain.ChartMessage;
import com.ruanku.domain.Message;
import com.ruanku.service.ChartMessageService;
import com.ruanku.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChartMessageServiceImpl implements ChartMessageService {

    @Autowired
    private ChartMessageDao chartMessageDao;


    //根据会员Id和管理员Id查询
    public List<ChartMessage> FindChartMessage(Integer memberId, Integer administratorId) {
        return chartMessageDao.FindChartMessage(memberId,administratorId);
    }

    //根据会员Id和管理员Id以及isRead查询
    public List<ChartMessage> FindMAIsRead(Integer memberId, Integer administratorId,String receiver) {
        return chartMessageDao.FindMAIsRead(memberId,administratorId,receiver);
    }

    //插入发送的消息
    public void Add(ChartMessage chartMessage) {
        chartMessageDao.Add(chartMessage);
    }

    //根据memberId和administratorId修改消息isRead为2已读状态
    public void Update(Integer memberId, Integer administratorId,String receiver) {
        chartMessageDao.Update(memberId,administratorId,receiver);
    }

}
