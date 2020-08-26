package com.leetcode.learning.q1114;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Foo {

    private Lock lock = null;
    private Condition first = null;
    private Condition second = null;
    private AtomicBoolean flag1 = new AtomicBoolean(false);
    private AtomicBoolean flag2 = new AtomicBoolean(false);

    public Foo() {
        lock = new ReentrantLock();
        first = lock.newCondition();
        second = lock.newCondition();
    }

    public void first() throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        lock.lock();
        try {
            System.out.println("first");
            flag1.compareAndSet(false, true);
            first.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second() throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        lock.lock();
        try {
            if (!flag1.get())
                first.await();
            System.out.println("second");
            flag2.compareAndSet(false, true);
            second.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third() throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        lock.lock();
        try {
            if (!flag2.get())
                second.await();
            System.out.println("third");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread.sleep(1000);
        t2.start();
        t3.start();


        Thread.sleep(5000);

//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("second");
//            }
//        });
//
//        Thread t3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Third");
//            }
//        });

    }

}