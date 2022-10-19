package papa;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Homework {
    private static final int THREAD_COUNT = 100;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        UserCounter1 userCounter1 = new UserCounter1();
        ExecutorService executorService = Executors.newSingleThreadExecutor(r -> {
            Thread t = new Thread(r, "counter-thread");
            t.setDaemon(true);
            return t;
        });

        Long result = CompletableFuture.supplyAsync(userCounter1::incrementAndGet, executorService).thenApply(i -> {
                    System.out.println(Thread.currentThread().getName());
                    return i * 2;
                })
                .join();
        System.out.printf("result = %s, %s %n ", result, Thread.currentThread().getName());
        executorService.shutdown();
    }
}


interface Counter {
    void increment();

    long getValue();

    long incrementAndGet();
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

    public synchronized long incrementAndGet() {
        increment();
        return getValue();
    }
}
