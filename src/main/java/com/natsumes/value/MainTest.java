package com.natsumes.value;

import org.apache.lucene.util.NamedThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hetengjiao
 */
public class MainTest {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,
                200L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(500),
                new NamedThreadFactory("test"));
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> setValue("TestOne", "hhah1"));
            executor.execute(() -> setValue("", "hhah5"));
            executor.execute(() -> setValue("TestTwo", "hhah2"));
            executor.execute(() -> setValue("TestThree", "hhah3"));
            executor.execute(() -> setValue("TestFour", "hhah4"));

        }

        executor.shutdown();
    }

    public static void  setValue(String key,String value){
        Commond.getCommond(key).setValue(value);
    }

}
