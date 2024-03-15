package Class;

import Interface.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Users implements User {
    private String name;
    private List<Posts> posts = new ArrayList<>();
    private List<User> followers = new ArrayList<>();

    public Users(String nome) {
        this.name = nome;
    }

    public String getName() {
        return name;
    }

    @Override
    public void MakePost(){

    }

    @Override
    public void FollowUser(String NameUser) {

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
