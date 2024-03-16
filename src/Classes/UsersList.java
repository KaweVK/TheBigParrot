package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class UsersList {
    private List<Users> users = new ArrayList<>();

    public List<Users> getUsers() {
        return users;
    }

    public List<Posts> showPostsFromUser(String userName) {
        for (Users users : users) {
            if (users.getName().equals(userName)) {
                return users.getPosts();
            }
        }
        return null;
    }

    public Users Follow(String userName) {
        for (Users users: users) {
            if (users.getName().equals(userName)) {
                return users;
            }
        }
        return null;
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
