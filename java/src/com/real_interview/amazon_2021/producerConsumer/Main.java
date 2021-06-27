package com.real_interview.amazon_2021.producerConsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Main {
    Queue<Integer> queue = new ThreadNotSafeQueue();
    Object mutex = new Object();
    Semaphore prd = new Semaphore(10), con = new Semaphore(10);
    ProducerTest p = new ProducerTest(prd, con, mutex, queue);
    ConsumerTest c = new ConsumerTest(prd, con, mutex, queue);
}
