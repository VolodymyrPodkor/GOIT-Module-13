package GOIT_Module_13;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class HttpUtil {
 private static final HttpClient CLIENT = HttpClient.newHttpClient();
 private static final Gson GSON = new Gson();

 public static User sentPostUser(URI uri, User user) throws IOException, InterruptedException {
     String requestBody = GSON.toJson(user);
    HttpRequest request = HttpRequest.newBuilder()
            .uri(uri)
            .header("Content-type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(requestBody))
            .build();
   HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
   return GSON.fromJson(response.body(), User.class);
 }

 public static User updatePutUser(URI uri, User user) throws IOException, InterruptedException {
    String requestBody = GSON.toJson(user);
    HttpRequest request = HttpRequest.newBuilder()
            .uri(uri)
            .header("Content-type", "application/json")
            .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
            .build();
     HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
     return  GSON.fromJson(response.body(), User.class);
 }

 public static void  deleteUser(URI uri, User user) throws IOException, InterruptedException {
     String requestBody = GSON.toJson(user);
     HttpRequest request = HttpRequest.newBuilder()
             .uri(uri)
             .header("Content-type", "application/json")
             .method("DELETE", HttpRequest.BodyPublishers.ofString(requestBody))
             .build();
     HttpResponse<Void> response = CLIENT.send(request, HttpResponse.BodyHandlers.discarding());

     int code = response.statusCode();

     if(code >= 200 && code < 300){
         System.out.println("Об'єкт user був видалений");
     }
     else {
         System.out.println("Помилка в видаленні об'єкта user");
     }
 }

 public static List<User> getAllResultsOfUsers(URI uri) throws IOException, InterruptedException {
     HttpRequest request = HttpRequest.newBuilder()
             .uri(uri)
             .header("Content-type", "application/json")
             .GET()
             .build();
     HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
     return GSON.fromJson(response.body(), new TypeToken<List<User>>(){}.getType());

 }

 public static User getUserById(URI uri, int userId) throws IOException, InterruptedException {
     HttpRequest request = HttpRequest.newBuilder()
             .uri(URI.create(uri.toString() + "/" + userId))
             .header("Content-type", "application/json")
             .GET()
             .build();
     HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
    return GSON.fromJson(response.body(), User.class);
 }

 public static User getUserByUsername(URI uri, String username) throws IOException, InterruptedException {
     HttpRequest request = HttpRequest.newBuilder()
             .uri(URI.create(uri.toString() + "?username=" + username))
             .header("Content-type", "application/json")
             .GET()
             .build();
     HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
     List<User> users = GSON.fromJson(response.body(), new TypeToken<List<User>>(){}.getType());

     for (User user : users){
         if(user.getUsername().equals(username)){
             return user;
         }
     }
     System.out.println("Не вдалось знайти користувача за username " + username);
     return null;
 }

                                    // Завдання 2

    public static int getLastPostUser(URI uri, int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri.toString() + "/" + userId + "/posts"))
                .header("Content-type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        List<Comment> comments = GSON.fromJson(response.body(), new TypeToken<List<Comment>>(){}.getType());
            return comments.get(comments.size() - 1).getId();
    }

    public static List<Comment> getLastCommentsPostOfUser(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), new TypeToken<List<Comment>>(){}.getType());

    }

                                          // Завдання 3

      public static List<Todo> getOpenUserTasks(URI uri, int userId) throws IOException, InterruptedException {
      HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create(uri.toString() + "/" + userId + "/todos"))
              .header("Content-type", "application/json")
              .GET()
              .build();
      HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
      List<Todo> todos = GSON.fromJson(response.body(), new TypeToken<List<Todo>>(){}.getType());

      List<Todo> openTodos = new ArrayList<>();
      for (Todo todo : todos){
          if(!todo.isCompleted()){
              openTodos.add(todo);
          }
      }
      return openTodos;
}}

