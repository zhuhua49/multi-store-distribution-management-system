package com.ruanku.dao;

import com.ruanku.domain.Member;
import com.ruanku.domain.Message;
import com.ruanku.domain.Sale;
import com.ruanku.domain.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao {


    //查询所有消息
    @Select("select * from message")
    public List<Message> FindAll();

    //根据memberId查询消息
    @Select("select * from message where memberId=#{memberId}")
    public List<Message> FindMemberId(Integer memberId);

    //根据memberId和isRead消息
    @Select("select * from message where memberId=#{memberId} and isRead=#{isRead}")
    public List<Message> FindMemberIdIsRead(Message message);

    //插入发送的消息
    @Insert("insert into message (administratorId,memberId,content,mTime,remarks,isRead) values (#{administratorId},#{memberId},#{content},#{mTime},#{remarks},#{isRead})")
    public void SendMessage(Message message);

    //修改信息为已读1为未读2为已读
    @Update("update message set isRead=2 where memberId=#{memberId}")
    public void Update(int memberId);

}