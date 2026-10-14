
package com.training.dto;

import java.time.LocalTime;

public class Session_P12 {

    private String userId;
    private String eventType;
    private LocalTime eventTime;

    public Session_P12(String userId, String eventType, LocalTime eventTime) {
        this.userId = userId;
        this.eventType = eventType;
        this.eventTime = eventTime;
    }
    public String getUserId() {
        return userId;
    }

    public String getEventType() {
        return eventType;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }
}