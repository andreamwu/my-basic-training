package Section01.chapter03.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer访问<T>的对象，并对其中每个元素进行操作
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        forEach(Arrays.asList(1, 2, 3, 4, 5),
                // Lambda是accept方法的实现
                (Integer i) -> System.out.println(i)
        );
    }

    /**
     * 遍历集合
     *
     * @param list
     * @param c
     * @param <T>
     */
    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i : list) {
            c.accept(i); // accept()它接受泛型 T 的对象，没有返回, 需要访问类型 T 的对象，并对其执行某些操作
        }
    }
}
