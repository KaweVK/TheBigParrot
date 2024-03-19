package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe UserList, repositório de objetos da classe Users
 * @author Kawe
 * */
public class UsersList {
    private List<Users> users = new ArrayList<>();

    public List<Users> getUsers() {
        return users;
    }

    /**
     * Método para mostrar todos os posts referentes a um usuário
     * @param userName Nome do usuário que deseja mostrar os posts
     * @param usersList Repositório de usuários onde o usuário está registrado
     * @throws Exception O usuário não pode ser nulo ou vazio
     * @throws Exception O usuário não foi encontrado no repositório
     * @return Caso o usuário possua posts, retorna todos os posts do usuário
     * */
    public String showPostsFromUser(String userName, UsersList usersList) throws Exception {
        if (userName == null || userName.trim().isEmpty()){
            throw new Exception("O usuário não pode ser nulo ou vazio");
        } else if (!usersList.hasUser(userName)) {
            throw new Exception("O usuário não foi encontrado");
        }
        for (Users user : users) {
            if (user.getName().equals(userName)) {
                String posts = "";
                for (Posts post : user.getPosts()) {
                    posts += "> " + user.getName() + " -> " + post.showPost() + "\n";
                }
                return posts;
            }
        }
        return userName + " ainda não publicou nada";
    }

    /**
     * Método para se obter um usuário
     * @param userName Nome do usuário que se deseja obter
     * @param usersList Repositório onde o usuário está registrado
     * @throws Exception O nome do usuário não pode ser nulo ou vazio
     * @throws Exception O usuário não foi encontrado no repositório
     * @return Retorna o objeto da classe Users referente ao usuário
     * */
    public Users getOneUser(String userName, UsersList usersList) throws Exception {
        if (userName == null || userName.trim().isEmpty()) {
            throw new Exception("O nome do usuário não pode ser nulo ou vazio");
        } else if (!usersList.hasUser(userName)){
            throw new Exception("O usuário não foi encontrado");
        }
        for (Users users: users) {
            if (users.getName().equals(userName)) {
                return users;
            }
        }
        return null;
    }

    /**
     * Método para saber se um usuário está registrado no repositório
     * @param userName Nome do usuário que se deseja obter
     * @return Retorna um boolean True, se o objeto estiver no reporitório e, do contrário, retorna False
     * */
    public boolean hasUser(String userName) {
        for (Users users: users) {
            if (users.getName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para registrar um usuário no respositório
     * @param user Objeto da classe Users que vai ser inserido no repositório
     * */
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
