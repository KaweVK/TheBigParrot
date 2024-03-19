package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class UsersList {
    private List<Users> users = new ArrayList<>();

    public List<Users> getUsers() {
        return users;
    }

    public String showPostsFromUser(String userName) throws Exception {
        if (userName == null || userName.trim().isEmpty()){
            throw new Exception("O usuário não pode ser nulo ou vazio");
        }
        for (Users user : users) {
            if (user.getName().equals(userName)) {
                String posts = "";
                for (Posts post : user.getPosts()) {
                    posts += "> " + user.getName() + " -> " + post + "\n";
                }
                return posts;
            }
        }
        return userName + " ainda não publicou nada";
    }

    public Users getOneUser(String userName, UsersList usersList) throws Exception {
        if (userName == null || userName.trim().isEmpty()) {
            throw new Exception("O nome do usuário não pode ser nulo ou vazio");
        }
        if (!usersList.hasUser(userName)){
            throw new Exception("O usuário não foi encontrado");
        }
        for (Users users: users) {
            if (users.getName().equals(userName)) {
                return users;
            }
        }
        return null;
    }

    public boolean hasUser(String userName) {
        for (Users users: users) {
            if (users.getName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public void insertUser(Users user) {
        users.add(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersList usersList = (UsersList) o;
        return Objects.equals(users, usersList.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    @Override
    public String toString() {
        return "UsersList{" +
                "users=" + users +
                '}';
    }
}
