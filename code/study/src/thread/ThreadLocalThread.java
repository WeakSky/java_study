package thread;

import com.sun.deploy.util.BlackList;

/**
 * ThreadLocal简单使用
 *
 * @author: lx
 * @date: 2023年03月30日 10:45
 */
public class ThreadLocalThread {
    static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    static class TestThread extends Thread {
        private Integer i;

        public TestThread(Integer num) {
            this.i = num;
        }

        @Override
        public void run() {

            while (!Thread.currentThread().isInterrupted()) {
                //赋值
                threadLocal.set(i);
                //获取值
                threadLocal.get();
                System.out.println(Thread.currentThread().getName() + ":threadLocal:" + threadLocal.get());
                System.out.println(Thread.currentThread().getName() + ":i:" + i);
                i++;
            }
            //清空
            threadLocal.remove();

        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i =0;i<3;i++){
            Thread thread =new TestThread(i);
            thread.start();
            Thread.sleep(20);
        }

        Thread.sleep(1000);



    }
}
