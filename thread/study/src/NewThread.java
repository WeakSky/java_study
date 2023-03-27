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
            System.out.println("thread start");
        }
    }

    static class UseRunable implements Runnable{
        @Override
        public void run() {
            System.out.println("runable start");
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
        Exthread exthread =new Exthread();
       /*
        1、start方法用来启动相应的线程；
        2、run方法只是thread的一个普通方法，在主线程里执行；
        3、需要并行处理的代码放在run方法中，start方法启动线程后自动调用run方法；
        4、run方法必须是public的访问权限，返回类型为void。
        */
        new Thread(exthread).start();
        new Thread(exthread).run();


        UseRunable useRunable =new UseRunable();
        new Thread(useRunable).start();

        UseCallable useCallable = new UseCallable();
        FutureTask<String> futureTask =new FutureTask<>(useCallable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());//get方法是阻塞的，一直等着回来结果

    }
}
