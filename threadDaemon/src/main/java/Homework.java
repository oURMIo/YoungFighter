import java.util.concurrent.*;

public class Homework {
    public static final int THREAD_COUNT = 100;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        UserCounter1 userCounter1 = new UserCounter1();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT, r -> {
            Thread t = new Thread(r, "counter-thread");
            t.setDaemon(true);
            return t;
        });
        CompletableFuture[] future1 = new CompletableFuture[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
//            future1[i] = executorService.submit(new RunnableUser(userCounter1));
            future1[i] = CompletableFuture.supplyAsync(userCounter1::incrementAndGet);
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            try {
                Object o = future1[i].get(10, TimeUnit.SECONDS);
                System.out.printf("obj %s = %s%n", i, o);
            } catch (ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("%n%n%n");
        for (int i = 0; i < THREAD_COUNT; i++) {
            Object obj = CompletableFuture.supplyAsync(userCounter1::getValue).join();
            System.out.printf(" %s", obj);
        }
        executorService.shutdown();
    }
}

interface Counter {
    void increment();

    long getValue();
}

class RunnableUser implements Callable<Object> {
    private final Counter counter;

    RunnableUser(Counter counter) {
        this.counter = counter;
    }

    @Override
    public Object call() {
        counter.increment();
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

    public synchronized long incrementAndGet() {
        increment();
        return getValue();
    }
}
