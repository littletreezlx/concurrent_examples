package producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class NoLockModel implements Producer, Consumer {

    private Queue<Object> queue = new LinkedList();
//    private int limit = 10;
    Object food;

    NoLockModel(){

    }

    @Override
    public void produce() {
        queue.offer(new Object());
        System.out.println("add success, ___"+queue.size());
    }

    @Override
    public void consume() {
        while (true) {
            if (!queue.isEmpty()) {
                queue.poll();
                System.out.println("take success, ___" + queue.size());
                return;
            }
        }

    }
}
