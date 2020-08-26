package com.leetcode.learning.q1115;


import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    private int n;

    private Lock lock = new ReentrantLock();
    private Condition cond_foo = lock.newCondition();
    private Condition cond_bar = lock.newCondition();
    private AtomicBoolean flag = new AtomicBoolean(false);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            lock.lock();
            try {
                if (flag.get()) {
                    cond_bar.await();
                }
                System.out.print("foo");
                flag.compareAndSet(false, true);
                cond_foo.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            lock.lock();
            try {
                if (!flag.get()) {
                    cond_foo.await();
                }
                System.out.print("bar");
                flag.compareAndSet(true, false);
                cond_bar.signal();

            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(100);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(null);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(null);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(500);
    }
}
