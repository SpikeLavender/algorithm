package com.natsumes.value;

import java.util.Random;

/**
 * @author hetengjiao
 */
public class ValueHandlerImpl1 implements IValueHandler {

    private Random rd = new Random();

    @Override
    public void setValue(String value) {
        try {
            Thread.sleep(rd.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test one " + value);
    }
}
