/**
 * 功能描述
 *
 * @author: lx
 * @date: 2023年03月28日 22:04
 */
public class DeamonThread {
    static class ExtendsThread extends Thread{

        @Override
        public void run(){
            String threadName = Thread.currentThread().getName();
            try{
                while (!isInterrupted()){
                    System.out.println(threadName+" running");
                }
            } finally {
                System.out.println("finally");
            }

            System.out.println(threadName+" interrput flag is "+Thread.currentThread().isInterrupted());
        }

    }
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new ExtendsThread();

        //设置为守护线程，守护线程和主线程同死  finally不能保证一定执行
        thread.setDaemon(true);

        thread.start();
        Thread.sleep(20);
        thread.interrupt();







    }
}
