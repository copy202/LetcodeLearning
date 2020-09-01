package com.leetcode.learning.q1116;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private CountDownLatch startLatch = new CountDownLatch(2);
    private CountDownLatch latchEven = new CountDownLatch(1);
    private CountDownLatch latchOdd = new CountDownLatch(1);
    private CountDownLatch latchZero = new CountDownLatch(1);
    private AtomicInteger evenCount = null;
    private AtomicInteger oddCount = null;
    private int MAX_EVEN, MAX_ODD;

    public ZeroEvenOdd(int n) {
        this.n = n;
        if (n % 2 == 0) {
            evenCount = new AtomicInteger(n / 2);
            oddCount = new AtomicInteger(n / 2);
        } else {
            evenCount = new AtomicInteger(n / 2);
            oddCount = new AtomicInteger(n / 2 + 1);
        }
        MAX_EVEN = evenCount.get();
        MAX_ODD = oddCount.get();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        startLatch.await();
        for (int i = 1; i <= n; i++) {
            printNumber.accept(0);
            if (i % 2 == 0) {
                //发送偶数许可
                latchEven.countDown();
            } else {
                //发送奇数许可
                latchOdd.countDown();
            }
            latchZero.await();
            latchZero = new CountDownLatch(1);
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        startLatch.countDown();
        while (evenCount.get() > 0) {
            //等待偶数许可
            latchEven.await();
            printNumber.accept(2 * (MAX_EVEN - evenCount.get()) + 2);
            evenCount.decrementAndGet();
            latchEven = new CountDownLatch(1);
            latchZero.countDown();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        startLatch.countDown();
        while (oddCount.get() > 0) {
            //等待奇数许可
            latchOdd.await();
            printNumber.accept(2 * (MAX_ODD - oddCount.get()) + 1);
            oddCount.decrementAndGet();
            latchOdd = new CountDownLatch(1);
            latchZero.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd zd = new ZeroEvenOdd(5);
        IntConsumer ic = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value);
            }
        };
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zd.zero(ic);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zd.odd(ic);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zd.even(ic);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(1000);
    }
}
