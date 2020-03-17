package com.example.spring.eventandjpa.notransaction;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @date:2019/12/20 21:45
 **/
@Component
public class MyNoTransactionEventHandler {

    public MyNoTransactionEventHandler() {
        System.out.println("---------------------------------");
        System.out.println("MyNoTransactionEventHandler----------------构造器");
    }

    @EventListener(classes = {MyNoTransactionEvent.class}, condition = "#dd.name=='张三'")
    public void myEvent1(MyNoTransactionEvent dd) {
        System.out.println("张三张三非事务事件被处理啦" + dd);
    }

    @EventListener(classes = {MyNoTransactionEvent.class}, condition = "#myNoTransactionEvent.name=='李四'")
    public void myEvent2(MyNoTransactionEvent myNoTransactionEvent) {
        System.out.println("李四李四非事务事件被处理啦" + myNoTransactionEvent);
    }

    @EventListener
    public void myEventAll(MyNoTransactionEvent myNoTransactionEvent) {
        System.out.println("MyNoTransactionEvent非事务事件被处理啦" + myNoTransactionEvent);
    }

}
