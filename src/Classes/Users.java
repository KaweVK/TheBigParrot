package Classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe para criação de usuários de uma rede social
 * @author Kawe
 * */
public class Users {
    private String name;
    private List<Posts> posts = new ArrayList<>(); //lsita dos posts do usuário
    private List<Users> following = new ArrayList<>(); //lista de usuários seguindo

    /**
     * */
    public Users(String name, UsersList usersList) {
        if (!usersList.getUsers().contains(name)){
            this.name = name;
        }
    }

    public void MakePost(String text){
        Posts newPosts = new Posts(text, LocalDate.now());
        this.posts.add(newPosts);
    }

    public void MakePost(String text, String name){

    }

    public void FollowUser(String nameUser, UsersList usersList) {
        for (Users users : usersList.getUsers()) {
            if (users.equals(nameUser)){
                following.add(users);
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public List<Users> getFollowing() {
        return following;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(name, users.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + name + '\'' +
                '}';
    }
}
