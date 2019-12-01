package apply;

//使用三个线程顺序打印有序的数组
public class OrderedArray {

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
        new Thread3().start();
    }


    public static void print(){


    }


    static volatile int num = 0;
    static Object lock = new Object();

    static class Thread1 extends Thread{
        @Override
        public void run() {
            super.run();
            while (true){
                if (num % 3 == 0 || num == 0){
                    synchronized (lock){
                        System.out.println(++num);

                        Thread.yield();
                    }
                }
            }
        }
    }

    static class Thread2 extends Thread{
        @Override
        public void run() {
            super.run();
            while (true){
                if (num % 3 == 1){
                    synchronized (lock){
                        System.out.println(++num);
                    }
                }
            }
        }
    }

    static class Thread3 extends Thread{
        @Override
        public void run() {
            super.run();
            while (true){
                if (num % 3 == 2){
                    synchronized (lock){
                        System.out.println(++num);
                    }
                }
            }
        }
    }


}
