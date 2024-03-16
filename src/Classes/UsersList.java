package Classes;

import java.util.ArrayList;
import java.util.List;


public class UsersList {
    private List<Users> users = new ArrayList<>();

    public List<Users> getUsers() {
        return users;
    }

    public List<Posts> showPosts(String name) {
        for (Users users : users) {
            if (users.getName().equals(name)) {
                return users.getPosts();
            }
        }
        return null;
    }

    public void insertUser(Users user){
        users.add(user);
    }
}
