package apply;

public class PrintAllThreads {

    public static void main(String[] args) throws InterruptedException {
//        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
//        ThreadInfo[] threadInfos=threadMXBean.dumpAllThreads(false,false);
//        for (ThreadInfo threadInfo : threadInfos) {
//            System.out.println(threadInfo.getThreadId()+"-"+threadInfo.getThreadName());
//        }

        Thread t1=new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        ThreadGroup threadGroup = t1.getThreadGroup();
        System.out.println(threadGroup);
        ThreadGroup systemThreadGroup = threadGroup.getParent();
        System.out.println(systemThreadGroup);
        systemThreadGroup.list();

    }

}
