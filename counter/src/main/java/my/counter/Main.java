package my.counter;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static final int THREAD_COUNNT = 20;

    public static void main(String[] args) throws InterruptedException {
        UserCounter1 userCounter1 = new UserCounter1();

        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(new RunnableUser(userCounter1, i));
        }

        for (int i = 0; i < THREAD_COUNNT; i++) {
            threads[i].start();
        }

    }
}

interface Counter {
    void increment();

    long getValue();
}

class RunnableUser implements Runnable {
    private final Counter counter;
    private int id;

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

