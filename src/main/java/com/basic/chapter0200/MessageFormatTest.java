package com.basic.chapter0200;

import java.text.MessageFormat;
import java.util.Date;

public class MessageFormatTest {
    public static void main(String[] args) {
        int planet = 7;
        String event = "a disturbance in the Force";
        String result = MessageFormat.format("At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.",
            planet, new Date(), event);
        System.out.println(result);
    }
}
