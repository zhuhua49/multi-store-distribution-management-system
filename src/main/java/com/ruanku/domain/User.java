package com.ruanku.domain;

public class User {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户聊天记录
     */
    private String userText;

    /**
     * 用户IP地址
     */
    private String userIp;

    /**
     * 用户最后发送时间
     */
    private String userSendTime;

    public User(String userId) {
        this.userId = userId;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserText() {
        return userText;
    }

    public void setUserText(String userText) {
        this.userText = userText;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getUserSendTime() {
        return userSendTime;
    }

    public void setUserSendTime(String userSendTime) {
        this.userSendTime = userSendTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userText='" + userText + '\'' +
                ", userIp='" + userIp + '\'' +
                ", userSendTime='" + userSendTime + '\'' +
                '}';
    }
}