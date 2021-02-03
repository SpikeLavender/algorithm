package com.natsumes.thread;

import org.junit.Test;

public class H2OTest {

    private H2O h2O;

    static class PrintRunnable implements Runnable {

        private final String name;

        public PrintRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.print(name + " ");
            System.out.flush();
        }
    }

    @Test
    public void test() throws InterruptedException {
        h2O = new H2O();

        for (int i = 0; i < 10; i++) {

            Thread t2 = new Thread(()-> {
                try {
                    h2O.oxygen(new PrintRunnable("O"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread t1 = new Thread(()-> {
                try {
                    h2O.hydrogen(new PrintRunnable("H"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

//            Thread t3 = new Thread(()-> {
//                try {
//                    h2O.hydrogen(new PrintRunnable("H"));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });

            t1.start();
            t2.start();
//            t3.start();
        }

        //while (true);
    }

}