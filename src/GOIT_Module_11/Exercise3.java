package GOIT_Module_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise3 {
    public static void main(String[] args) {
        String[] textNumbers = {"1, 2, 0", "4, 5"};

       String result = Arrays.stream(textNumbers)
               .map(text -> text.split(", "))
               .flatMap(str -> Arrays.stream(str))
               .mapToInt(text -> Integer.parseInt(text))
               .sorted()
               .mapToObj(number -> String.valueOf(number))
               .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}


