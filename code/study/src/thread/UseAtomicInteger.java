package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger的简单使用
 *
 * @author: lx
 * @date: 2023年04月13日 15:46
 */
public class UseAtomicInteger {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        System.out.println(atomicInteger.compareAndSet(10,5));   //原值10变成5   要是变成功了返回true
        System.out.println(atomicInteger.get());    //获取现在的值
        System.out.println(atomicInteger.getAndIncrement());   //先读取，然后再原值上加一
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.incrementAndGet()); //先加一再读取
        System.out.println(atomicInteger.get());
    }
}
