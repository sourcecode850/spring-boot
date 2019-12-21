package com.example.spring.eventandjpa;

import com.example.spring.eventandjpa.notransaction.MyNoTransactionEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @date:2019/12/20 21:27
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EventAndJpaTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void insertUser() {
        UserEntity userEntity = new UserEntity(1, "张三", "男");
        System.out.println(userRepository.save(userEntity));
    }

    @Test
    public void updateUser() {
        UserEntity userEntity = new UserEntity(1, null, null);
        userEntity.changeState("jpa-张三", userEntity.getGender());
        userRepository.save(userEntity);
    }

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Test
    public void testNoTransactionEvent() {
        MyNoTransactionEvent myNoTransactionEvent = new MyNoTransactionEvent("张三", "男");
        applicationContext.publishEvent(myNoTransactionEvent);
    }

}
