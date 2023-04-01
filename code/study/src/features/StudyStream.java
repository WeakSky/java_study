package features;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    }

}
