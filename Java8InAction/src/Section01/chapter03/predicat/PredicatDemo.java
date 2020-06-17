package Section01.chapter03.predicat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicat: 需要表示一个涉及类型  T 的布尔表达式时，就可以使用这个接口
 */
public class PredicatDemo {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("", "Java", "SE", "Development", "Kit", "8", "");

        Predicate<String> nonEmptyStringPredicate =
                // Lambda是Predicate 中实现的方法
                (String s) -> !s.isEmpty();
        List<String> filter = filter(listOfStrings, nonEmptyStringPredicate);

        System.out.println(filter);
    }

    /**
     * 根据条件过滤集合
     *
     * @param list
     * @param p   非空的字符串
     * @param <T>
     * @return 已过滤成功的集合
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) { //  test 的抽象方法，它接受泛型 T 对象，并返回一个 boolean
                results.add(s);
            }
        }
        return results;
    }
}
