package Classes;

import java.time.LocalDateTime;
import java.util.Objects;

public class Posts {
    private String content;
    private LocalDateTime date;

    public Posts(String content, LocalDateTime data ) {
        this.content = content;
        this.date = data;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posts posts = (Posts) o;
        return Objects.equals(content, posts.content) && Objects.equals(date, posts.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return "Posts{" +
                "content='" + content + '\'' +
                ", date=" + date +
                '}';
    }

    public String showPost() {
        return getContent() + " (" + getDate().getDayOfMonth() + "/" + getDate().getMonth() + "/" + getDate().getYear() + " " + getDate().getHour() + ":" + getDate().getMinute() + ")";
    }
}
