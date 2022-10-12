package papa;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MyWork {
    public static void main(String[] args) throws InterruptedException {
        Data data = new Data(10);
        Producer producer = new Producer(data);
        Consumer consumer = new Consumer(data);

        System.out.printf("data = %s %n %n", data.toString());

        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

        Thread producerThread = new Thread(producer);
        producerThread.start();

        TimeUnit.SECONDS.sleep(20);
        producerThread.interrupt();
        consumerThread.interrupt();
    }
}

class Data {
    private final Queue<String> data = new LinkedBlockingQueue<>();
    //    private List<Integer> data = new ArrayList<>();
    private final int size;
    private final Object producerMutex = new Object();
    private final Object consumerMutex = new Object();

    Data(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "papa.Data{" +
                "data=" + data +
                " data.size = " + data.size() +
                ", maxSize=" + size +
                '}';
    }

    public int getSize() {
        return size;
    }

    private boolean checkAndWaitIfFull() {
        synchronized (producerMutex) {
            while (data.size() >= size) {
                try {
                    producerMutex.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return data.size() < size;
                }
            }
            return true;
        }
    }

    private boolean checkIfEmptyAndWait() {
        synchronized (consumerMutex) {
            while (data.isEmpty()) {
                try {
                    consumerMutex.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return !data.isEmpty();
                }
            }
            return true;
        }
    }

    public boolean add(String add) {
        if (checkAndWaitIfFull()) {
            data.add(add);
            synchronized (consumerMutex) {
                consumerMutex.notifyAll();
            }
            return true;
        } else {
            return false;
        }
    }

    public String poll() {
        if (checkIfEmptyAndWait()) {
            String result = data.poll();
            synchronized (producerMutex) {
                producerMutex.notifyAll();
            }
            return result;
        } else {
            return null;
        }
    }
}

class Producer implements Runnable {

    private final Data data;

    Producer(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            String add = String.valueOf(i);
            data.add(add);
            System.out.printf("1 papa.Producer sale = %s %s %n", add, data);
        }
    }
}

class Consumer implements Runnable {

    private final Data data;

    Consumer(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            String getFromQueue = data.poll();
            System.out.printf("2 papa.Consumer getFromQueue = %s, current = %s %n", getFromQueue, data);
        }
    }
}

