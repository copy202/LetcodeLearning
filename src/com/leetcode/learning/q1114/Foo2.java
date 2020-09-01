package com.leetcode.learning.q1114;

import java.util.concurrent.SynchronousQueue;

class Foo2 {

    private SynchronousQueue<Integer> sQueue = new SynchronousQueue(true);
    private SynchronousQueue<Integer> sQueue2 = new SynchronousQueue(true);

    public Foo2() {
    }

    public void first() throws InterruptedException {
        System.out.println("first");
        sQueue.put(1);
    }

    public void second() throws InterruptedException {
        sQueue.take();
        System.out.println("second");
        sQueue2.put(2);
    }

    public void third() throws InterruptedException {
        sQueue2.take();
        System.out.println("third");
    }

    public static void main(String[] args) throws InterruptedException {
        Foo2 foo = new Foo2();
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
        t2.start();
        Thread.sleep(10000);
        t1.start();
        t3.start();


        Thread.sleep(5000);


    }

}