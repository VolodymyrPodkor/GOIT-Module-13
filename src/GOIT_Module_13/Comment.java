package GOIT_Module_13;

import java.util.Objects;

public class Comment {
    private int userId;
    private  int id;
    private String body;
    private String title;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment comment)) return false;
        return userId == comment.userId && id == comment.id && body.equals(comment.body) && title.equals(comment.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, id, body, title);
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", body='" + body + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
