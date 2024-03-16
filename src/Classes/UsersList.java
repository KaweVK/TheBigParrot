package Classes;

import java.util.ArrayList;
import java.util.List;


public class UsersList {
    private List<Users> users = new ArrayList<>();

    public List<Users> getUsers() {
        return users;
    }

    public List<Posts> showPosts(String userName) {
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
}
