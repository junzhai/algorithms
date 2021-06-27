package com.real_interview.amazon_2021.producerConsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ProducerTest {
    private final Semaphore prd, con;
    private final Object mutex;
    private final Queue<Integer> threadNotSafeQueue;

    public ProducerTest(Semaphore prd, Semaphore con, Object mutex, Queue<Integer> threadNotSafeQueue) {
        this.prd = prd;
        this.con = con;
        this.mutex = mutex;
        this.threadNotSafeQueue = threadNotSafeQueue;
    }

    private int slowProduce() {
        return -1;
    }

    public void run() throws InterruptedException {
        while (true) {
            // slow produce before lock
            int n = slowProduce();
            prd.acquire();
            synchronized (mutex) {
                threadNotSafeQueue.add(n);
            }
            con.release();
        }
    }
}
