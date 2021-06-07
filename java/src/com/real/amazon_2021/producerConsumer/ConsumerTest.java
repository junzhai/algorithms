package com.real.amazon_2021.producerConsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ConsumerTest {
    private final Semaphore prd, con;
    private final Object mutex;
    private final Queue<Integer> threadNotSafeQueue;

    public ConsumerTest(Semaphore prd, Semaphore con, Object mutex, Queue<Integer> threadNotSafeQueue) {
        this.prd = prd;
        this.con = con;
        this.mutex = mutex;
        this.threadNotSafeQueue = threadNotSafeQueue;
    }

    private void slowConsume(int n) {
    }

    public void run() throws InterruptedException {
        while (true) {
            int n;
            con.acquire();
            synchronized (mutex) {
                n = threadNotSafeQueue.remove();
            }
            prd.release();
            // Release before slow consume
            slowConsume(n);
        }
    }
}
