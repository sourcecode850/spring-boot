package com.example.spring.eventandjpa;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class UserDomainEventListener {

    /**
     * EventPublishingRepositoryProxyPostProcessor会发布事件
     *
     * @param userDomainEvent
     */
    @TransactionalEventListener(value = UserDomainEvent.class, condition = "#userDomainEvent.eventType=='USER_UPDATE_STATUS'", phase = TransactionPhase.AFTER_COMMIT)
    public void orderStatusUpdate(UserDomainEvent userDomainEvent) {
        // 这里订单已经持久化，发布了OrderDomainEvent，要做的处理就是同步其他限界上下文？https://segmentfault.com/a/1190000018888918?utm_source=tag-newest
        System.out.println("收到userDomainEvent事件：" + userDomainEvent);
    }

    @TransactionalEventListener(value = UserDomainEvent.class, condition = "#userDomainEvent.eventType=='USER_UPDATE_STATUS'", phase = TransactionPhase.AFTER_COMMIT)
    public void orderStatusUpdate2(UserDomainEvent userDomainEvent) {
        // 这里订单已经持久化，发布了OrderDomainEvent，要做的处理就是同步其他限界上下文？https://segmentfault.com/a/1190000018888918?utm_source=tag-newest
        System.out.println("收到userDomainEvent事件2：" + userDomainEvent);
    }

    public UserDomainEventListener() {
        // debug 切面的实例化以及切面是如何创建成代理的分析
        System.out.println("UserDomainEventListener-------------构造器");
    }

}