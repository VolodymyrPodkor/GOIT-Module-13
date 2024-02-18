package GOIT_Module_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 {
    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Maks", "Mark", "Stepan", "Volodymyr", "Anatolii", "Mykola");
        List<String> listResult = listSort(nameList);
        System.out.println(listResult);
    }

    private static List<String> listSort(List<String> nameList) {
        return nameList.stream()
                .map(name -> name.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
