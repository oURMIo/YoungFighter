package my.counter;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static final int THREAD_COUNT = 100;

    public static void main(String[] args) throws InterruptedException {
        UserCounter1 userCounter1 = new UserCounter1();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            executorService.submit(new RunnableUser(userCounter1, i));
        }

        executorService.shutdown();
    }
/*
    public static void main(String[] args) throws InterruptedException {
        UserCounter1 userCounter1 = new UserCounter1();
//        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNNT, new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                Thread t = new Thread(r, "counter-thread");
//                t.setDaemon(true);
//                return t;
//            }
//        });

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < THREAD_COUNNT; i++) {
            executorService.submit(new RunnableUser(userCounter1, i));
        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(1000, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            //nothing to do
        }
    }*/
}

interface Counter {
    void increment();

    long getValue();
}

class RunnableUser implements Runnable {
    private final Counter counter;
    private final int id;

    RunnableUser(Counter counter, int id) {
        this.counter = counter;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            counter.increment();
        }
        System.out.printf(" CountUser %s = %s %n", id, counter.getValue());
    }
}

/**
 * WITH SYNCHRONIZED
 */
class UserCounter1 implements Counter {
    private long value;

    @Override
    public synchronized void increment() {
        value++;
    }

    @Override
    public synchronized long getValue() {
        return value;
    }
}

/**
 * WITH LOCK
 */
class UserCounter2 implements Counter {
    private long value;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void increment() {
        lock.lock();
        try {
            value++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public long getValue() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }
}

/**
 * WITH ATOMICLONG
 */
class UserCounter3 implements Counter {
    AtomicLong atomicLong = new AtomicLong();

    @Override
    public void increment() {
        atomicLong.incrementAndGet();
    }

    @Override
    public long getValue() {
        return atomicLong.get();
    }
}

