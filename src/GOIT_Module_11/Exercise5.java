package GOIT_Module_11;

import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Exercise5 {
    public static void main(String[] args) {
        Stream<String> first = Stream.of("Maks", "Andrii", "Volodymyr");
        Stream<String> second = Stream.of( "Anatolii", "Kateryna", "Stepan", "Iryna");
        Stream<String> result = zip(first, second);
        result.forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        List<T> resultList = new ArrayList<>();

        List<T> firstList = first.sorted().toList();
        List<T> secondList = second.sorted(Collections.reverseOrder()).toList();

        Iterator<T> iterator1 = firstList.iterator();
        Iterator<T> iterator2 = secondList.iterator();


        while (iterator1.hasNext() && iterator2.hasNext()){
            resultList.add(iterator1.next());
            resultList.add(iterator2.next());
        }

        return resultList.stream();
    }
}
