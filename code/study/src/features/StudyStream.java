package features;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.IntStream.builder;
import static java.util.stream.IntStream.iterate;

/**
 * Stream学习
 *
 * @author: lx
 * @date: 2023年03月30日 14:56
 */
public class StudyStream {
/*    创建方式主流的有五种：
        1.Stream直接创建
        2.Collection集合创建
        3.Array数组创建
        4.文件创建
        5.函数创建

         //详细使用见
        //https://blog.csdn.net/MinggeQingchun/article/details/123184273
        */
    public static void main(String[] args) {
        //1.直接创建
        Stream<Integer> stream1 = Stream.of(1,2,3,4);
        //2.Collection集合创建
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Stream<Integer> listStream = list.stream();
        //3.Array数组创建
        int[] intArr = {1,2,3};
        IntStream arrayStream = Arrays.stream(intArr);
        //4.文件创建
        try{
            Stream<String> fileStrem = Files.lines(Paths.get("xxxx.txt"), Charset.defaultCharset());
        }catch (IOException e){
            e.printStackTrace();
        }
        //5.函数创建
            //iterator   iterate方法接受两个参数，第一个为初始化值，第二个为进行的函数操作，因为iterator生成的流为无限流，通过limit方法对流进行了截断，只生成5个偶数
        Stream<Integer> iteratorStream = Stream.iterate(0, n -> n+2 ).limit(5);
        IntStream aa= iterate(0, n -> n+2 ).limit(5);
            //generator    generate方法接受一个参数，方法参数类型为Supplier ，由它为流提供值。generate生成的流也是无限流，因此通过limit对流进行了截断
        Stream<Double> genaraterStream = Stream.generate(Math::random).limit(5);


        //！！！！中间操作符！！！！！！！！！！！！！！
        //大致有filter  map  distinct  sorted  limit  skip   flatMap   peek

        //filter 过滤
        List<User> filetrUserList = userList().stream().filter(user -> user.getId()>3).collect(Collectors.toList());
        filetrUserList.forEach(System.out::println);

        //map
        List<String> mapUserList = userList().stream().map(user -> user.getName()+"用户").collect(Collectors.toList());
        mapUserList.forEach(System.out::println);

        //distinct
        List<String> distinctUserAddress = userList().stream().map(user -> user.getAddress()).distinct().collect(Collectors.toList());
        distinctUserAddress.forEach(System.out::println);

        //sorted
        List<User> sortedUserList = userList();
        sortedUserList.forEach(System.out::println);
            //升序排
            sortedUserList = userList().stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
            //降序排
            sortedUserList = userList().stream().sorted(Comparator.comparing(User::getAge).reversed()).collect(Collectors.toList());
        //对象集合以类属性一降序、属性二升序 注意两种写法
        //list.stream().sorted(Comparator.comparing(类::属性一).reversed().thenComparing(类::属性二));//方式1：先以属性一升序,升序结果进行属性一降序,再进行属性二升序
        sortedUserList.forEach(System.out::println);

        //limit 返回一个长度为N的流
        userList().stream().limit(5).collect(Collectors.toList()).forEach(System.out::println);

        //skip 返回一个扔掉前面N的流
        userList().stream().skip(5).forEach(System.out::println);

        //peek 对元素进行遍历
        userList().stream().peek(user -> user.setAge(user.getAge()+99)).forEach(System.out::println);

        //flatMap
        //7、flatMap：数据拆分一对多映射  （不是很懂用处，后面再看看）
        userList().stream().flatMap(user -> Arrays.stream(user.getAddress().split(","))).forEach(System.out::println);
        userList().stream().forEach(System.out::println);
        //使用map入参和返参都是对象实体
        //用flatmap入参和返参都是stream对象
        //map是对一级元素进行操作，flatmap是对二级元素操作map返回一个值




        //!!!!!!!!!!!!终端操作符！！！！！！！！！！！
        //下面的方法只能执行一次，无法再执行其他动作，执行完成后流就被关闭。想再在后面执行其他操作，得重新新建一个stream流
        //collect forEach findFirst findAny count sum max min anyMatch allMatch noneMatch reduce



        //!!!!!!!!!!Collect 收集!!!!!!!!!!!!!!!!!!!
        //toList
        //toMap
        //toSet
        //counting
        //summingInt
        //minBy
        //joining
        //groupingBy
    }

    public static List<User> userList(){
        List<User> userList = new ArrayList<>();
        userList.add(new User(1,"张三",1,"SH"));
        userList.add(new User(2,"王五",3,"上海"));
        userList.add(new User(3,"李四",3,"上海"));
        userList.add(new User(4,"张雷",2,"北京"));
        userList.add(new User(5,"张超",5,"深圳"));
        userList.add(new User(6,"李雷",3,"北京"));
        userList.add(new User(7,"王爷",7,"上海"));
        userList.add(new User(8,"张三丰",8,"广州"));
        userList.add(new User(9,"赵六",9,"广州"));
        userList.add(new User(10,"赵无极",10,"深圳"));

        return userList;
    }

   public static class User {
        private int id;
        private String name;
        private int age;
        private String address;
       public User(int id, String name, int age, String address) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }


       @Override
       public String toString() {
           return "User{" +
                   "id=" + id +
                   ", name='" + name + '\'' +
                   ", age=" + age +
                   ", address='" + address + '\'' +
                   '}';
       }
   }

}
