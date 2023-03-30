package thread;

/**
 * 功能描述
 *
 * @author: lx
 * @date: 2023年03月27日 22:09
 */
public class EndThread {

    static class ExtendsThread extends Thread{
        public ExtendsThread(String name){
            super(name);
        }
        @Override
        public void run(){
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()){
                System.out.println(threadName+" running");
            }
            System.out.println(threadName+" interrput flag is "+Thread.currentThread().isInterrupted());
        }

    }
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new ExtendsThread("heihei");
        thread.start();
        Thread.sleep(20);
        thread.interrupt();


        //java线程是协作式
        //强行终止，不一定释放资源。
        thread.stop();
        // 中断一个线程，由该线程自己决定是否自己是否终止 中断标志位标记为true
        thread.interrupt();
        //判定当前线程是否处于中断状态，获取中断标志位
        thread.isInterrupted();
        //判定当前线程是否处于中断状态 并将中断标志位改为false （该方法会恢复（清除）中断标志）
        thread.interrupted();





    }
}
