package com.ruanku.service;

import com.ruanku.domain.Administrator;
import com.ruanku.domain.Message;

import java.util.List;

public interface MessageService {

    //查询所有消息
    public List<Message> FindAll();

    //根据memberId查询消息
    public List<Message> FindMemberId(Integer memberId);

    //根据memberId和isRead查询消息
    public List<Message> FindMemberIdIsRead(Message message);

    //插入发送的消息
    public void SendMessage(Message message);

    //将消息设为已读
    public void Update(int memberId);
}
