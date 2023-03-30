package thread.notify;

/**
 * 假装是个快递类  用于测试notify 和notifyAll
 * notifyAll
 * @author: lx
 * @date: 2023年03月30日 11:27
 */
public class Express {
    //起始地
    public static final String START_CITY = "SH";
    //实际位置
    private String now_city;
    //走了多远了
    private int km;

    public Express(String now_city,int km){
        this.now_city = now_city;
        this.km = km;
    }

    public synchronized void  changeCT(){

        this.now_city = "YN";
        //唤醒线程栈上最先进去的wait线程
        notify();
    }

    public synchronized void changeKM(){
        this.km = 101;
        //唤醒所有wait线程
        notifyAll();
    }

    public synchronized void waitChangeCT()  {
        while (!START_CITY.equals(now_city)){
            System.out.println("waitChangeCT等待中");
            try {
                //不传数字就是永久等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("地点改变");
    }


    public synchronized void waitChangeKM()  {
        while (km<100){
            System.out.println("waitChangeKM等待中");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("路程改变");
    }
}
