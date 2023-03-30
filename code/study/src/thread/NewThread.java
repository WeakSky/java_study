package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 启动新线程
 * 继承Thread，实现Runable，实现Callable
 *
 * @author: lx
 * @date: 2023年03月27日 21:07
 */
public class NewThread {
    static class Exthread extends Thread{
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()){
                System.out.println(threadName+" running");
            }
            System.out.println(threadName+" interrput flag is "+Thread.currentThread().isInterrupted());
        }
    }

    static class UseRunable implements Runnable{
        @Override
        public void run() {
            System.out.println("runable start");
            String threadName = Thread.currentThread().getName();
            while (Thread.currentThread().isInterrupted()){
                System.out.println(threadName+" running");
            }
            System.out.println(threadName+" interrput flag is "+Thread.currentThread().isInterrupted());

        }
    }

    static class UseCallable implements Callable<String>{
        @Override
        public String call() throws Exception {
            System.out.println("callable start");
            return "this is callable";
        }
    }

    public static void main(String[] agrs) throws ExecutionException, InterruptedException {

        Thread thread = new Exthread();
        /*
        1、start方法用来启动相应的线程；
        2、run方法只是thread的一个普通方法，在主线程里执行；
        3、需要并行处理的代码放在run方法中，start方法启动线程后自动调用run方法；
        4、run方法必须是public的访问权限，返回类型为void。
        */
        thread.start();
        thread.run();


        UseRunable useRunable =new UseRunable();
        new Thread(useRunable).start();

        UseCallable useCallable = new UseCallable();
        FutureTask<String> futureTask =new FutureTask<>(useCallable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());//get方法是阻塞的，一直等着回来结果

/*************************************************
        //java线程是协作式
        //强行终止，不一定释放资源。
        thread.stop();
        // 中断一个线程，由该线程自己决定是否自己是否终止 中断标志位标记为true
        thread.interrupt();
        //判定当前线程是否处于中断状态，获取中断标志位
        thread.isInterrupted();
        //判定当前线程是否处于中断状态 并将中断标志位改为false （该方法会恢复（清除）中断标志）
        thread.interrupted();
        *********************************************************************/

        thread.start();
        Thread.sleep(20);
        thread.interrupt();







    }
}
