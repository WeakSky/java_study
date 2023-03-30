package features;

import java.util.Optional;

/**
 * 学习Optional
 *
 * @author: lx
 * @date: 2023年03月30日 14:03
 */
public class StudyOptional {
    public static void main(String[] args) {
/*        Optional创建有三种方式,
 *           1. empty()
 *           2. of(对象)
 *           3. ofNullable(对象)
 *      不要将Optional作为类中的字段，它不能序列化！！！
 */
        /**************创建***************************************/
        //创建一个空的Optional实例
        Optional<String> empty = Optional.empty();

        //返回非空值的Optional。of静态方法需要一个非null参数；否则，将引发空指针异常
        String name = "name";
        Optional<String> opt = Optional.of(name);

        //可以传入空值，空值的话就返回空的Optional对象，
        Optional<String> optional = Optional.ofNullable(address());

        /***********使用*****************************************/
        System.out.println("isPresent(),存在值返回true，"+optional.isPresent());
        // 这个只支持jdk11以上版本
        // System.out.println("是否存在值，存在就返回false，"+opt.isEmpty());
        //如果存在值，则使用该值调用指定的使用者；否则，什么都不做。
        opt.ifPresent(s -> System.out.println(s.length()));

        //不为空就返回本身，为空就返回orElse的东西
        String a = empty.orElse("aaaaa");
        String b = opt.orElse("aaaaa");

        //不为空就返回本身，为空返回orElseGet调用的方法
        String c = optional.orElseGet(() -> "ccccccc");

        StudyOptional studyOptional =new StudyOptional();
        studyOptional.different();

    }

    public  void different(){
        String text = null;
        String defaultText = null;
        //是不是为空都会调用方法
        defaultText = Optional.ofNullable(text).orElse(getDefaultValue());
        //为空了才会调用方法，懒加载
        defaultText = Optional.ofNullable(text).orElseGet(this::getDefaultValue);

    }

    static String address(){
        String addre = "SH";
        return (addre.length()>6)?addre:null;
    }

    public  String getDefaultValue() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }
}
