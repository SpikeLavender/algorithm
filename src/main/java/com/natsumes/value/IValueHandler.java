package com.natsumes.value;

/**
 * @author hetengjiao
 */
public interface IValueHandler {

    void setValue(String value);

    static IValueHandler getTestOneHandler() {
        return new ValueHandlerImpl1();
    }

    static IValueHandler getTestTwoHandler() {
        return new ValueHandlerImpl2();
    }

    static IValueHandler getTestThreeHandler() {
        return new ValueHandlerImpl3();
    }

    static IValueHandler getTestFourHandler() {
        return new ValueHandlerImpl4();
    }

    static IValueHandler getDefaultHandler() {
        return new DefaultValueHandlerImpl();
    }
}
