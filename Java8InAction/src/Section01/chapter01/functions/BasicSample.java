package Section01.chapter01.functions;

import Section01.chapter01.common.Apple;

import java.util.*;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * 匿名函数
 */
public class BasicSample {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        // Java8 从传递方法到 Lambda
        List<Apple> greenApples = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        System.out.println(greenApples);

        List<Apple> heavyApples = filterApples(inventory,
                (Apple a) -> "red".equals(a.getColor()) || a.getWeight() < 150);
        // [Apple{color='green', weight=80}, Apple{color='red', weight=120}]
        System.out.println(heavyApples);

        // Java8 函数式编程可以直接调用几个相关的通用库方法
        /** static <T> Collection<T> filter(Collection<T> c, Predicate<T> p); */

        // 流的顺序处理:转化为流再转回List
        List<Apple> appleList = inventory.stream()
                .filter((Apple a) -> "green".equals(a.getColor()) && a.getWeight() > 150)
                .collect(toList());
        // [Apple{color='green', weight=155}]
        System.out.println(appleList);
        // 流的并行处理
        List<Apple> list = inventory.parallelStream()
                .filter((Apple a) -> "green".equals(a.getColor()) && a.getWeight() > 150)
                .collect(toList());
        System.out.println(list);
    }

    // Java8
    /**
     * 挑选苹果
     *
     * @param inventory 库存
     * @param p         方法作为谓语参数 p 传递,并返回 true 或 false
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> appleList = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) { // 判断苹果符合p的条件吗？
                appleList.add(apple);
            }
        }
        return appleList;
    }

    //
    public static boolean isGreenApple(Apple apple) {
        return ("Green".equals(apple.getColor()));
    }
    //
    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    //
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    //
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }
}
