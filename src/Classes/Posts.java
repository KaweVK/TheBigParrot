package Classes;

import java.time.LocalDate;

public class Posts {
    private String content;
    private LocalDate data = LocalDate.now();

    public Posts(String content, LocalDate data ) {
        this.content = content;
        this.data = data;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }
}
