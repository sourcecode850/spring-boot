package com.example.spring.eventandjpa;

import lombok.Data;

@Data
public class UserDomainEvent {

    public String eventType;

    public UserDomainEvent(UserDomainEventTypeEnum eventTypeEnum) {
        this.eventType = eventTypeEnum.name();
    }

    public enum UserDomainEventTypeEnum {
        /**
         * 用户状态变化
         */
        USER_UPDATE_STATUS,
    }

}