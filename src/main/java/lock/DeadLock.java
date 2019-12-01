package lock;

public class DeadLock {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable1()).start();
        Thread.sleep(500);
        new Thread(new Runnable2()).start();
    }

    public static Object lockA = new Object();
    public static Object lockB = new Object();

    public static void getA(){
        synchronized (lockA){
            System.out.println("getA!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getB();
        }
        System.out.println("getA");
    }

    public static void getB(){
        synchronized (lockB){
            System.out.println("getB!");
            getA();
        }
        System.out.println("getB");
    }


   static class Runnable1 implements Runnable {
        @Override
        public void run(){
            getA();
        }
    }

    static class Runnable2 implements Runnable {
        @Override
        public void run(){
            getB();
        }
    }

}


