package com.natsumes.value;

/**
 * @author hetengjiao
 */
public class ValueHandlerImpl3 implements IValueHandler {
    @Override
    public void setValue(String value) {
        System.out.println("test three " + value);
    }
}
