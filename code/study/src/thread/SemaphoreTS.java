package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量最简单的使用
 *
 * @author: lx
 * @date: 2023年04月13日 8:38
 */
public class SemaphoreTS {

    static Semaphore semaphore = new Semaphore(2);
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                try {
                    semaphore.acquire();
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
            thread.start();
        }
    }


}
