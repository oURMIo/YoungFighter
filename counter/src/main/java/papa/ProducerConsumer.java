package papa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> messages = new ArrayList<>();
        Producer2 producer2 = new Producer2(messages);
        Consumer2 consumer = new Consumer2(messages);

        Thread producerThread = new Thread(producer2);
        producerThread.start();

        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

        TimeUnit.SECONDS.sleep(2);
        producerThread.interrupt();
        consumerThread.interrupt();

    }
}

class Producer2 implements Runnable {

    private final List<Integer> messages;
    private int i;

    Producer2(List<Integer> messages) {
        this.messages = messages;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (messages) {
                messages.add(i);
                System.out.println("produce = " + i);
                i++;
                while (!messages.isEmpty()) {
                    try {
                        messages.wait(1);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }
    }
}

class Consumer2 implements Runnable {

    private final List<Integer> messages;

    Consumer2(List<Integer> messages) {
        this.messages = messages;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (messages) {
                if (!messages.isEmpty()) {
                    System.out.println("consumer = " + messages.remove(0));
                    messages.notifyAll();
                }
            }
        }
    }
}
