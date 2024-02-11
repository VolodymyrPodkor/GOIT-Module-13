package GOIT_Module_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Exercise1 {
    public static void main(String[] args) {

        File file = new File("src/GOIT_Files/TelephoneNumbers.txt");
        if(!file.exists()){
            System.out.println("Файл не знайдений. Не вірно вказаний шлях до файла");
        }
        extracted(file);
    }

    private static void extracted(File file) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                if(validNumber(line)) {
                    System.out.println(line);
                }
            }
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static boolean validNumber(String number){
        return number.matches("\\(\\d{3}\\) \\d{3}-\\d{4}") || number.matches("\\d{3}-\\d{3}-\\d{4}");
    }
}
