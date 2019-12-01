public class Main {

    static int count=0;

    static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        new Thread(){
            @Override
            public void run() {
//                object.wait();

                for (int i = 0; i <10000000 ; i++) {
                    synchronized (object){
                        count++;
                        try {
                            System.out.println("wait");
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("自定义线程:计算完成...，耗时"+(System.currentTimeMillis()-start));
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <10000000 ; i++) {
                    synchronized (object){
                        count++;
                        System.out.println("notify");
                        object.notify();
                    }
                }
                System.out.println("自定义线程:计算完成...，耗时"+(System.currentTimeMillis()-start));
            }
        }.start();
    }

}
