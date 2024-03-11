package GOIT_Module_13;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.List;

public class HttpDemo {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
    public static void main(String[] args) throws IOException, InterruptedException {

                           // Завдання 1
        User user = createNewUser();

        User createUser = HttpUtil.sentPostUser(URI.create(BASE_URL), user);
        System.out.println(createUser);

        User updateUser = HttpUtil.updatePutUser(URI.create(BASE_URL), user);
        System.out.println(updateUser);

        HttpUtil.deleteUser(URI.create(BASE_URL), user);

         List<User> allResultsOfUsers = HttpUtil.getAllResultsOfUsers(URI.create(BASE_URL));
        System.out.println(allResultsOfUsers);

        int ID = 7;
        User userById = HttpUtil.getUserById(URI.create(BASE_URL), ID);
        System.out.println(userById);

        String userName = "Antonette";
        User userByUsername = HttpUtil.getUserByUsername(URI.create(BASE_URL), userName);
        System.out.println(userByUsername);

                            // Завдання 2

        int userId = 2;
        int lastIdPost = HttpUtil.getLastPostUser(URI.create(BASE_URL), userId);
        List<Comment> comments = HttpUtil.getLastCommentsPostOfUser(URI.create("https://jsonplaceholder.typicode.com/posts/" + lastIdPost + "/comments"));
        saveCommentsToFile(userId, lastIdPost, comments);

                             // Завдання 3

        List<Todo> openUserTodos = HttpUtil.getOpenUserTasks(URI.create(BASE_URL), userId);
        System.out.println(openUserTodos);
    }

    private static void saveCommentsToFile(int userId, int postId, List<Comment> comments) {
        String fileName = "user-" + userId + "-post-" + postId + "-comments.json";
        Gson gson = new Gson();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            gson.toJson(comments, fileWriter);
            System.out.println("Comments записані в файл: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static User createNewUser() {
        User user = new User();
        user.setId(1);
        user.setName("Volodymyr");
        user.setUsername("Podkorytov");
        user.setEmail("1234567890@gmail.com");
        user.setPhone("555-555-55");
        return user;
    }
}
