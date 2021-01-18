package com.natsumes.value;

/**
 * @author hetengjiao
 */
public class ValueHandlerImpl2 implements IValueHandler {
    @Override
    public void setValue(String value) {
        System.out.println("test two " + value);
    }
}
