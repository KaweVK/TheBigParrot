package Classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe para criação de usuários de uma rede social
 * @author Kawe
 * */
public class Users {
    private String name; //nome do usuário
    private List<Posts> posts = new ArrayList<>(); //lsita dos posts do usuário
    private List<Users> following = new ArrayList<>(); //lista de usuários seguindo

    /**
     * Construtor da classe Users
     * @param name Nome do usuário
     * @param usersList Lista de usuários que armazena os atuais usuários
     * */
    public Users(String name, UsersList usersList) { //Completo
        if (!usersList.getUsers().contains(name)){
            this.name = name;
        }
    }

    /**
     * Método que postar algo no mural do usuário que for indicado
     * @param user Usuário que vai fazer a nova publicação
     * @param content Conteudo da nova publicação
     * @param usersList Lista de usuários onde se encontra o usuário que vai fazer a postagem
     * */
    public void makePost(String user, String content, UsersList usersList){ //Completo
        Users userToPost = usersList.getOneUser(user);
        Posts newPosts = new Posts(content, LocalDateTime.now());
        userToPost.posts.add(newPosts);
    }

    /**
     * Método para seguir um usuário que esteja cadastrado no Grande Papagaio
     * @param nameOfUserToFollow Nome do usuário que deseja seguir
     * @param usersList Lista de usuários onde o usuário informado no último parâmetro deve se encontrar*/
    public void followUser(String nameOfUserWhoWillFollow, String nameOfUserToFollow, UsersList usersList) { //Completo
        Users userWhoWillFollow = usersList.getOneUser(nameOfUserWhoWillFollow);
        Users userToFollow = usersList.getOneUser(nameOfUserToFollow);
        if (userToFollow != null) {
            userWhoWillFollow.following.add(userToFollow);
        }//lançar excessão que não pode ser nulo
    }

    public void showMural(UsersList usersList) {
        for (Users user : usersList.getUsers()){
            if (following.contains(user)){
                user.getPosts();
            }
        }
    }

    //completos:
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
        return "Users{" +
                "name='" + name + '\'' +
                ", posts=" + posts +
                ", following=" + following +
                '}';
    }
}
