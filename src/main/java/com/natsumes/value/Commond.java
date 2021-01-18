package com.natsumes.value;

/**
 * @author hetengjiao
 */
public enum Commond {
    /**
     *
     */
    TEST_ONE("TestOne") {
        @Override
        protected void setUp() {
            valueHandler = IValueHandler.getTestOneHandler();
        }
    },

    TEST_TWO("TestTwo") {
        @Override
        protected void setUp() {
            valueHandler = IValueHandler.getTestTwoHandler();
        }
    },

    TEST_THREE("TestThree"){
        @Override
        protected void setUp() {
            valueHandler = IValueHandler.getTestThreeHandler();
        }
    },

    TEST_FOUR("TestFour"){
        @Override
        protected void setUp() {
            valueHandler = IValueHandler.getTestFourHandler();
        }
    },

    DEFAULT(""){
        @Override
        protected void setUp() {
            valueHandler = IValueHandler.getDefaultHandler();
        }
    },
    ;

    private String type;

    private static IValueHandler valueHandler;

    Commond(String type){
        this.type = type;
    }

    public static Commond getCommond(String type) {
        for (Commond value : Commond.values()) {
            if (type.equals(value.type)) {
                return value;
            }
        }
        return DEFAULT;
    }

    protected abstract void setUp();

    public void setValue(String value) {
        setUp();
        valueHandler.setValue(value);
    }

    public String getType() {
        return this.type;
    }

}
