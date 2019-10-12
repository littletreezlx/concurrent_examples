package producer_consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockModel implements Producer, Consumer {

    private Queue<Object> queue = new LinkedList();
    Object food;

    ReentrantLock isEmpty;
    Condition docondition;
    Condition eatcondition;


    ReentrantLockModel(){
        isEmpty = new ReentrantLock();
        docondition = isEmpty.newCondition();
        eatcondition = isEmpty.newCondition();

    }

    @Override
    public void produce() {
        isEmpty.lock();

        queue.offer(new Object());
        System.out.println("add success, ___"+queue.size());

        try {
            docondition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        eatcondition.signal();

        isEmpty.unlock();
    }

    @Override
    public void consume() {
        isEmpty.lock();
        if(queue.isEmpty()){

            try {
                System.out.println("await to eat...");
                eatcondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            queue.poll();
            System.out.println("take success, ___" + queue.size());
            docondition.signal();
        }
        isEmpty.unlock();
    }
}
