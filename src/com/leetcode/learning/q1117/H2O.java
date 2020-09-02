package com.leetcode.learning.q1117;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class H2O {

    private Semaphore hySep = new Semaphore(2);
    private Semaphore oxSep = new Semaphore(1);

    private AtomicInteger count = new AtomicInteger();

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        hySep.acquire();
        releaseHydrogen.run();
        handleResult();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        oxSep.acquire();
        releaseOxygen.run();
        handleResult();
    }

    private void handleResult() {
        int now = count.incrementAndGet();
        if (now == 3) {
            count.compareAndSet(3, 0);
            hySep.release(2);
            oxSep.release(1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        H2O h2O = new H2O();
        Runnable releaseHydrogen = new Runnable() {
            @Override
            public void run() {
                System.out.print("H");
            }
        };
        Runnable releaseOxygen = new Runnable() {
            @Override
            public void run() {
                System.out.print("O");
            }
        };
        String input = "OOHHHH";
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'H') {
                threadList.add(new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            h2O.hydrogen(releaseHydrogen);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }));
            } else if (input.charAt(i) == 'O') {
                threadList.add(new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            h2O.oxygen(releaseOxygen);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }));
            }
        }

        for (Thread t : threadList) {
            t.start();
        }

        Thread.sleep(1000);
    }
}
