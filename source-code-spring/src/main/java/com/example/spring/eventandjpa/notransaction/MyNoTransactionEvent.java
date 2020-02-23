package com.example.spring.eventandjpa.notransaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @date:2019/12/20 21:46
 **/
@Data
@AllArgsConstructor
public class MyNoTransactionEvent {

    private String name;
    private String gender;

    public MyNoTransactionEvent(){
        System.out.println("MyNoTransactionEvent");
    }
}
