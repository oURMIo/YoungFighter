import java.util.*;
import java.util.concurrent.Semaphore;

public class CircularQueue {
    Queue<Integer> queue = new LinkedList<Integer>();
    final int LIMIT = 10;
    static Semaphore semProd = new Semaphore(1);
    static Semaphore semConsu = new Semaphore(0);

    public void enqueue(int productId) throws InterruptedException {

        semProd.acquire();
        queue.add(productId);
        System.out.println(Thread.currentThread().getName() + " Putting(In Q) Product ID:" + productId);
        semConsu.release();
    }

    public int deueue() throws InterruptedException {
        semConsu.acquire();
        int productID = (int) queue.remove();
        System.out.println(Thread.currentThread().getName() + " Getting (In Q) Product ID:" + productID);
        semProd.release();
        return productID;
    }
}


//producer class
class Producer3 implements Runnable {
    CircularQueue cQueue;

    public Producer3(CircularQueue queue) {
        this.cQueue = queue;

    }

    public void run() {
        while (true) {
            for (int i = 0; i < 5; i++) {

                try {
                    cQueue.enqueue(i);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }
}


//consumer class
class Consumer3 implements Runnable {

    CircularQueue cQueue;

    public Consumer3(CircularQueue cQueue) {
        this.cQueue = cQueue;

    }

    public void run() {

        try {
            while (true) {
                int item = cQueue.deueue();
//                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}


//Driver Class
class DriverClass {

    public static void main(String args[]) {

        CircularQueue cQueue = new CircularQueue();
        new Thread(new Producer3(cQueue)).start();
        new Thread(new Consumer3(cQueue)).start();


    }
}