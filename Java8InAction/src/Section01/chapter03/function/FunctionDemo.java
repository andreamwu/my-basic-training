package Section01.chapter03.function;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/**
 * Function 需要定义一个Lambda，将输入对象的信息映射到输出，就可以使用这个接口
 */
public class FunctionDemo {
    public static void main(String[] args) {
        List<Integer> list = map(Arrays.asList("Lambda", "in", "action", "编程", "프로 그래 밍"),
                // Lambda是Function接口的apply()的实现
//               String::length
                (String s) -> s.length()
        );
        // [6, 2, 6, 2, 7]
        System.out.println(list);
    }

    /**
     * 统计集合中每个元素的字符个数
     * @param list
     * @param f
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s)); //  f.apply它接受一个泛型 T 的对象，并返回一个泛型 R 的对象
        }
        return result;
    }
}
