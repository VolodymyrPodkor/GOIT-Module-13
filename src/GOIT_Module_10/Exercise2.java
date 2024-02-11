package GOIT_Module_10;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;

public class Exercise2 {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        ArrayList<User> users = new ArrayList<>();
        File fileInput = new File("src/GOIT_Files/file.txt");
        File fileOutput = new File("src/GOIT_Files/user.json");
        if(!fileInput.exists() || !fileOutput.exists()){
            System.out.println("Файл не знайдений. Не вірно вказаний шлях до файла");
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(fileInput))){
          String line;
          while ((line = reader.readLine()) != null){
              String parts[] = line.split(" ");

              User user = new User();
              user.name = parts[0];
              user.age = Integer.parseInt(parts[1]);
              users.add(user);
            }
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

        try(FileWriter writer = new FileWriter(fileOutput)){
            gson.toJson(users, writer);
        }
        catch (IOException e){
            throw  new RuntimeException(e);
        }
    }
}

class User{
    String name;
    int age;

    public String toString() {
        return "[User " +
                "name='" + name   +
                ", age=" + age +"]";
    }
}
