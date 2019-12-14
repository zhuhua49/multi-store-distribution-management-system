package com.ruanku.service.Impl;

import com.ruanku.dao.AdminDao;
import com.ruanku.dao.MessageDao;
import com.ruanku.domain.Administrator;
import com.ruanku.domain.Message;
import com.ruanku.service.AdminService;
import com.ruanku.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    //查询所有消息
    public List<Message> FindAll() {
        return null;
    }

    //根据memberID查询
    public List<Message> FindMemberId(Integer memberId) {
        return messageDao.FindMemberId(memberId);
    }

    //根据memberID和isRead查询
    public List<Message> FindMemberIdIsRead(Message message) {
        return messageDao.FindMemberIdIsRead(message);
    }

    //插入发送的消息
    public void SendMessage(Message message) {
        Date date = new Date();
        message.setmTime(date);
        messageDao.SendMessage(message);
    }

    //将消息设为已读
    public void Update(int memberId) {
        messageDao.Update(memberId);
    }


}
