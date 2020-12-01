package com.jwc.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaDemo003 {
    // 通过数组来生成
    static void gen1() {
        String[] strs = {"a", "b", "c", "d"};
        Stream<String> strs1 = Stream.of(strs);
        strs1.forEach(System.out::println);
    }

    // 通过集合来生成
    static void gen2() {
        List<String> list = Arrays.asList("1", "2", "3", "4");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }

    // generate
    static void gen3() {
        Stream<Integer> generate = Stream.generate(() -> 1);
        generate.limit(10).forEach(System.out::println);
    }

    // 使用iterator
    static void gen4() {
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1);
        iterate.limit(10).forEach(System.out::println);
    }

    // 其他方式
    static void gen5() {
        String str = "abcdefg";
        IntStream stream = str.chars();
        stream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Optional<Integer> option1 = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter((x) -> x % 2 == 0).findAny();
        Optional<Integer> option2 = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter((x) -> x % 2 == 0).findFirst();
        System.out.println(option1.get());
        System.out.println(option2.get());

        Optional<Integer> option3 = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter((x) -> x % 2 == 0).max((a, b) -> a - b);
        Optional<Integer> option4 = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter((x) -> x % 2 == 0).min((a, b) -> a - b);
        System.out.println(option3.get());
        System.out.println(option4.get());

        int sum1 = Arrays.asList("1", "2", "3", "4", "5", "6").stream().mapToInt((x) -> Integer.valueOf(x) + 2).sum();
        int sum2 = Arrays.asList("1", "2", "3", "4", "5", "6").stream().map(Integer::valueOf).mapToInt(x -> x).sum();
        System.out.println(sum1);
        System.out.println(sum2);

        System.out.println("--------------------");
        String[] a = {"a", "g", "b", "s", "c"};
        Stream.of(a).sorted().forEach(System.out::println);

        System.out.println("--------------------");
        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("python");
        list.add("csharp");
        list.add("shell");
        list.stream().sorted((o1, o2) -> o1.length() - o2.length()).forEach(System.out::println);


        System.out.println("--------------------");
        Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 1, 5, 7).stream().distinct().forEach((x) -> System.out.println(x));
        Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 1, 5, 7).stream().distinct().forEach(System.out::println);
        Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 1, 5, 7).stream().collect(Collectors.toSet()).forEach(System.out::println);

    }
}
