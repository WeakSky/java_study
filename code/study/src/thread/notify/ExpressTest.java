package thread.notify;

/**
 * 类说明：测试wait/notify/notifyAll
 *  notify();//唤醒线程栈上最先进去的wait线程，不一定是哪个线程
 *  notifyAll();唤醒全部等待的线程
 *  一般使用notifyAll()来唤醒线程，保证唤醒成功
 * @author: lx
 * @date: 2023年03月30日 15:38
 */
public class ExpressTest {
    static Express express = new Express("YN", 1);

    static class CheckKm extends Thread {
        @Override
        public void run() {
            express.waitChangeKM();
        }
    }

    static class CheckCT extends Thread {
        @Override
        public void run() {
            express.waitChangeCT();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread kmThread = new CheckKm();
            kmThread.start();
            Thread ctThread = new CheckCT();
            ctThread.start();
        }
        Thread.sleep(1000);

         express.changeKM();
       // express.changeCT();



    }
}
