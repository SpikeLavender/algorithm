package com.natsumes.value;

/**
 * @author hetengjiao
 */
public class DefaultValueHandlerImpl implements IValueHandler {
    @Override
    public void setValue(String value) {
        System.out.println("default " + value);
    }
}
