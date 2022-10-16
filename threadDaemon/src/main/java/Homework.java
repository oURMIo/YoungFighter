import java.util.concurrent.*;

public class Homework {
    public static final int THREAD_COUNT = 100;

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        UserCounter1 userCounter1 = new UserCounter1();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT, r -> {
            Thread t = new Thread(r, "counter-thread");
            t.setDaemon(true);
            return t;
        });

        Future<?> future = null;
        for (int i = 0; i < THREAD_COUNT; i++) {
            int finalI = i;
            future = executorService.submit(() -> {
                executorService.submit(new RunnableUser(userCounter1, finalI));
            });
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            try {
                future.get(10, TimeUnit.SECONDS);
            } catch (ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
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
