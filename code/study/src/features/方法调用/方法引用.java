package features.方法调用;

/**
 *
 * 方法引用的三种形式
 * 对象 :: 非静态方法
 * 类 :: 静态方法
 * 类 :: 非静态方法
 *
  下面这种属于难得！！！
 * 类引用普通方法
 * 语法格式： 类::普通方法
 * 类引用普通方法就有点难以理解了。
 * 当抽象方法中有两个参数，且第一个参数是调用者，第二个参数是形参，则可以使用类::实例方法。
 *
 *
 * 这个难理解！！！！！要多看看！！！！！！
 */
public class 方法引用 {
    public static void main(String[] args) {
        Person person1 = new Person("张三", 22);
        Person person2 = new Person("李四", 23);
        // 符合T res = p1.compare(p2);
        IMessage<Boolean, Person> msg = Person::equal;

        //所以第一个参数就是调用者，第二个是形参
        System.out.println(msg.compare(person1, person2));


    }
}

@FunctionalInterface
interface IMessage<T, P> {
    // 要看成 T res = p1.compare(p2);
    public T compare(P p1, P p2);
}


class Person {
    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    private String name;
    private Integer age;

    public boolean equal(Person per) {
        System.out.println("this.name:"+this.name);
        System.out.println("per.name:"+per.name);
        return this.name.equals(per.getName()) && this.age.equals(per.getAge());
    }
}
