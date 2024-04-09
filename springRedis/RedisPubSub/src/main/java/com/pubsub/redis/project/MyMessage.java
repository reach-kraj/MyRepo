package com.pubsub.redis.project;

import java.util.List;

public class MyMessage {
    private int notificationId;
    private String source;
    private List<String> recipients;
    private String notificationMsg;

    // Constructor
    public MyMessage() {
    }

    // Getters and setters
    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    public String getNotificationMsg() {
        return notificationMsg;
    }

    public void setNotificationMsg(String notificationMsg) {
        this.notificationMsg = notificationMsg;
    }
}

