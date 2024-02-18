package GOIT_Module_11;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise1 {
    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Maks", "Mark", "Stepan", "Volodymyr", "Anatolii", "Mykola", "Andrii");
        String result = printNames(nameList);
        System.out.println(result);
    }

    private static String printNames(List<String> nameList) {
        return nameList.stream()
                .filter(name -> (nameList.indexOf(name) + 1) % 2 != 0)
                .map(name -> (nameList.indexOf(name) + 1) + ". " + name)
                .collect(Collectors.joining(", "));
    }



}
