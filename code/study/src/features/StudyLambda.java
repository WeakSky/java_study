package features;

/**
 * Lambda
 *      (匿名内部类被重写方法的形参列表) -> {
 * 	             重写方法
 *     }
 *
 *     lambda 的本质就是函数式接口的一个实现类
 *
 * lambda 表达式形式为 ()->{}，-> 左边是抽象方法的形参列表， -> 是抽象方法的实现体。
 * lambda 方法如果没有参数或有两个及以上的参数，则 小括号不能省略。
 * lambda 方法如果只有一个参数，则小括号可以省略。
 * lambda 方法体如果只有一行语句，则 大括号和return都可省略。
 * 省略了大括号，则必须省略 return，省略了 return ，则必须省略 {}，这俩要么成对出现，要么都不出现。
 *
 * 详见  https://blog.csdn.net/weixin_44061521/article/details/110943897
 * 此处省略了方法引用
 */


public class StudyLambda {
    interface IMessage {
        public void send(String str);
    }

    interface IMath{
        public int add(int x , int y);
    }

    public static void main(String[] args) {

        //原生
        IMessage i = new IMessage() {
            public void send(String str) {
                System.out.println(str);
            }
        };
        i.send("aaaaa");

        //lambda
        IMessage ii = (str) ->{
            System.out.println(str);
        };
        ii.send("bbbbb");

        //lambda 可以省略return的
        IMessage iii = ss -> System.out.println("www.baidu.com");


        //add的入参就是aa和bb 返回值就是aa+bb
        IMath mm = (aa,bb) -> aa+bb;
        System.out.println(mm.add(1,2));


    }
}
