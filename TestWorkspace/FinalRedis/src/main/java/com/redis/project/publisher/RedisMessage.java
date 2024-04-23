package com.redis.project.publisher;

import java.io.Serializable;
import java.util.List;

public class RedisMessage implements Serializable {
	private int notificationId;
	private String source;

	public RedisMessage() {
	}

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

}
