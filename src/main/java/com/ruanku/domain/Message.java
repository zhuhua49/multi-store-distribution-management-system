package com.ruanku.domain;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    private int messageId;
    private int administratorId;
    private int memberId;
    private String content;
    private Date mTime;
    private String remarks;
    private int isRead;

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(int administratorId) {
        this.administratorId = administratorId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", administratorId=" + administratorId +
                ", memberId=" + memberId +
                ", content='" + content + '\'' +
                ", mTime=" + mTime +
                ", remarks='" + remarks + '\'' +
                ", isRead=" + isRead +
                '}';
    }
}
