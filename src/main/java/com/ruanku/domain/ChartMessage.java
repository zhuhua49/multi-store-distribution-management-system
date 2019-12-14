package com.ruanku.domain;

import java.sql.Timestamp;

public class ChartMessage {

    /**
     * 消息ID
     */
    private Integer messageId;

    /**
     * 发送者Name
     */
    private String sender;

    /**
     * 接收者名称
     */
    private String receiver;

    /**
     * 管理员id
     */
    private Integer administratorId;

    /**
     * 会员id
     */
    private Integer memberId;

    /**
     * 发送的信息
     */
    private String messageText;

    /**
     * 发送的时间
     */
    private Timestamp messageDate;


    /**
     * 是否阅读
     */
    private Integer isRead;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Timestamp getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Timestamp messageDate) {
        this.messageDate = messageDate;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    @Override
    public String toString() {
        return "ChartMessage{" +
                "messageId=" + messageId +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", administratorId=" + administratorId +
                ", memberId=" + memberId +
                ", messageText='" + messageText + '\'' +
                ", messageDate=" + messageDate +
                ", isRead=" + isRead +
                '}';
    }
}