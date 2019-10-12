package producer_consumer;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        LinkBlockingQueueModel model = new LinkBlockingQueueModel();
//        NoLockModel model = new NoLockModel();
        ReentrantLockModel model = new ReentrantLockModel();

        startConsume(model);
        Thread.sleep(1000);

        startProduce(model);
//        Thread.sleep(1000);
//        startConsume(model);
    }

    private static void startProduce(Producer producer){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    producer.produce();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private static void startConsume(Consumer consumer){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    consumer.consume();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
