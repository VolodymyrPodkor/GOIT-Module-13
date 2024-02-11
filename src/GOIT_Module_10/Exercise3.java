package GOIT_Module_10;


import java.io.*;
import java.util.*;

public class Exercise3 {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        File file = new File("src/GOIT_Files/words.txt");
        if(!file.exists()){
            System.out.println("Файл не знайдений");
            return;
        }
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] words = line.split(" ");
                for (String word : words){
                    treeMap.put(word, treeMap.getOrDefault(word, 0) +1);
                }
            }
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(treeMap.entrySet());
        entryList.sort(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));


        for (Map.Entry<String, Integer> entry : entryList){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
