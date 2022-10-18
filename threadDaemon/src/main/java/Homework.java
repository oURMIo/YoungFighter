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
        Future[] future1 = new Future[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            int finalI = i;
            future1[i] = future = executorService.submit(() -> {
                executorService.submit((Runnable) new RunnableUser(userCounter1, finalI));
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

        System.out.printf("%n%n%n");
        for (int i = 0; i < THREAD_COUNT; i++) {
            System.out.printf(" %s", future1[i].get());
        }
    }
}


interface Counter {
    void increment();

    long getValue();
}

class RunnableUser implements Runnable, Callable {
    private final Counter counter;
    private final int id;

    RunnableUser(Counter counter, int id) {
        this.counter = counter;
        this.id = id;
    }

    @Override
    public void run() {
/*        for (int i = 0; i < 1; i++) {
        }*/
        counter.increment();
        System.out.printf(" CountUser %s = %s %n", id, counter.getValue());
    }

    @Override
    public Object call() throws Exception {
        return counter.getValue();
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
