package producer_consumer;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkBlockingQueueModel implements Producer, Consumer {

    LinkedBlockingQueue queue;
    Object food;

    LinkBlockingQueueModel(){
        queue = new LinkedBlockingQueue(10);
    }

    @Override
    public void produce() {
        try {
            queue.put(new Object());
            System.out.println("put success, ___"+queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void consume() {
        try {
            queue.take();
            System.out.println("take success, ___"+queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
