package java8.streams;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreams {
    public static final void main(String [] args) {
        Stream<String> stream = Stream.of("a", "b", "c");
        String[] arr = new String[] {"a", "b", "c"};
        Stream<String> stream2 = Arrays.stream(arr);
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("ba");
        list.add("ca");
        list.add("aa");
        list.add("ca");
        Stream<String> stream3 = list.stream();

        long count = list.stream().distinct().count();
        System.out.println("Elementos distintos = " + count);

        Stream<String> elementosConA = list.stream().filter(element -> element.contains("a"));
        System.out.println("Elementos con A=" + elementosConA.collect(Collectors.joining(" | ")));

        boolean isExist= list.stream().anyMatch(element->element.contains("a"));
        System.out.println("Existe?" + isExist);

        Stream<Path> streamDePaths = stream.map(uri -> Paths.get(uri));

        List<Integer> integers = Arrays.asList(5, 8, 2);
        Integer reduced = integers.stream().reduce(100, (a, b) -> a + b);
        System.out.println("Suma = " + reduced);

        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Nº mayor : " + stats.getMax());
        System.out.println("Nº menor : " + stats.getMin());
        System.out.println("Suma: " + stats.getSum());
        System.out.println("Media : " + stats.getAverage());

        list.parallelStream().forEach(element -> enParalelo(element));
    }

    private static void enParalelo(String element) {
        System.out.println("Ejecutando elemento " + element + " en el thread " + Thread.currentThread().getName());
    }
}
