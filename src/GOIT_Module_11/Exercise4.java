package GOIT_Module_11;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Exercise4 {
    public static void main(String[] args) {
       long a = 25214903917L;
       long c = 11L;
       long m = (long) Math.pow(2, 48);
       long seed = 1;
       Stream<Long> longStream = Stream.iterate(seed, x -> (a * x + c) % m);

       longStream.limit(20).forEach(System.out::println);
    }
}
