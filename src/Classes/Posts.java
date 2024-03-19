package Classes;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Classe Posts do sistema de postagens do Grande Papagaio
 * @author Kawe
 * */
public class Posts {
    private String content;
    private LocalDateTime date;

    /**
     * Construtor da classe Posts
     * @param content Conteúdo escrito da publicação
     * @param data Data e hora da publicação
     * */
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

    /**
     * Método para mostrar um post formatado com conteúdo, data e hora
     * @return Retorna uma String formatada do post
     * */
    public String showPost() {
        return getContent() + " (" + getDate().getDayOfMonth() + "/" + getDate().getMonth() + "/" + getDate().getYear() + " " + getDate().getHour() + ":" + getDate().getMinute() + ")";
    }
}
