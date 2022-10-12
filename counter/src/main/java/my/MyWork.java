package My;

import java.util.*;
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

        TimeUnit.SECONDS.sleep(2);
        producerThread.interrupt();
        consumerThread.interrupt();
    }
}

class Data {
    private Queue<Integer> data = new LinkedList<>();
    //    private List<Integer> data = new ArrayList<>();
    private int size;

    public Data(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        String time = null;
        for (int i = 0; i < getSize(); i++) {
            time = getData().toString();
        }
        return time;
    }

    public void setUnitList(int id, Integer number) {
        data.remove(id + 1);
        data.add(number);
    }

    public Queue<Integer> getData() {
        return data;
    }

    public void setData(Queue<Integer> data) {
        this.data = data;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

class Producer implements Runnable {

    private final Data data;

    public Producer(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        synchronized (data) {
            for (int i = 0; i < data.getSize(); i++) {
                try {
                    data.wait();
                } catch (Exception e) {
                }
                data.setUnitList(i, i + 1);
                System.out.printf("1 Producer sale = %s %n", data.toString());
                data.notifyAll();
            }
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
        /*///// KOSTIL!!! /////
         /////////////////////
         * */
        try {
            data.wait(50);
        } catch (Exception e) {
        }
        synchronized (data) {
            for (int i = 0; i < data.getSize(); i++) {
                try {
                    data.wait();
                } catch (Exception e) {
                }
                data.setUnitList(i, -1);
                System.out.printf("2 Consumer buy = %s %n", data.toString());
                data.notifyAll();
            }
        }
    }
}

