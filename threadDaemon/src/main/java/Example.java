import java.util.concurrent.*;

public class Example {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor(r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });
        Future<?> future = executor.submit(() -> {
            try {
                System.out.println("Сейчас начну!");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Долгое выполнение выполнено");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        try {
            future.get(10, TimeUnit.SECONDS);
        } catch (ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
