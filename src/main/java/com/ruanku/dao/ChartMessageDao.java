package com.ruanku.dao;

import com.ruanku.domain.ChartMessage;
import com.ruanku.domain.Message;
import com.ruanku.domain.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface ChartMessageDao {


    //根据memberId和administratorId修改消息isRead为2已读状态
    @Update("update chartmessage set isRead=2 where memberId=#{memberId} and administratorId=#{administratorId} and receiver=#{receiver}")
    public void Update(@Param("memberId") Integer memberId,@Param("administratorId") Integer administratorId,@Param("receiver") String receiver);

    //根据memberId和administratorId查询消息
    @Select("select * from chartmessage where memberId=#{memberId} and administratorId=#{administratorId}")
    public List<ChartMessage> FindChartMessage(@Param("memberId") Integer memberId,@Param("administratorId") Integer administratorId);

    //根据memberId、administratorId和isRead查询消息
    @Select("select * from chartmessage where memberId=#{memberId} and administratorId=#{administratorId} and isRead=1 and receiver=#{receiver}")
    public List<ChartMessage> FindMAIsRead(@Param("memberId") Integer memberId, @Param("administratorId") Integer administratorId,@Param("receiver") String receiver);

    //插入发送的消息
    @Insert("insert into chartmessage (sender,receiver,administratorId,memberId,messageText,messageDate,isRead) values (#{sender},#{receiver},#{administratorId},#{memberId},#{messageText},#{messageDate},1)")
    public void Add(ChartMessage chartMessage);

}