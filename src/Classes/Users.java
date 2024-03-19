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
     * @param userName Nome do usuário
     * @param usersList Lista de usuários que armazena os atuais usuários
     * @throws Exception O nome de usuário deve ser único, e não pode ser vazio ou nulo
     * */
    public Users(String userName, UsersList usersList) throws Exception { //Completo
        if (usersList.hasUser(userName)){
            throw new Exception("Nome de usuário já está em uso");
        }
        if (userName == null || userName.trim().isEmpty()){
            throw new Exception("O nome de usuário não pode ser nulo ou vazio");
        }
        this.name = userName;
    }

    /**
     * Método que postar algo no mural do usuário que for indicado
     * @param userName Usuário que vai fazer a nova publicação
     * @param content Conteudo da nova publicação
     * @param usersList Lista de usuários que armazena o usuário que vai fazer a postagem
     * @throws Exception O nome do usuário deve estar registrado, e nem ele nem o conteúdo da publicação podem ser nulos ou vazios
     * */
    public void makePost(String userName, String content, UsersList usersList) throws  Exception { //Completo
        if (userName == null || userName.trim().isEmpty()) {
            throw new Exception("O nome do usuário não pode ser nulo ou vazio");
        } else if (content == null || content.trim().isEmpty()) {
            throw new Exception("O conteúdo não pode ser nulo nem vazio");
        }
        Users userToPost = usersList.getOneUser(userName, usersList);
        Posts newPosts = new Posts(content, LocalDateTime.now());
        userToPost.posts.add(newPosts);
    }

    /**
     * Método para seguir um usuário que esteja cadastrado no Grande Papagaio
     * @param nameOfUserWhoWillFollow Nome do usuário que está logado e vai começar a seguir outro
     * @param nameOfUserToFollow Nome do usuário que deseja seguir
     * @param usersList Lista de usuários que armazena o usuário informado no último parâmetro
     * @throws Exception O nome do usuário (seguidor ou seguindo) não pode ser nulo ou vazio
     * */
    public void followUser(String nameOfUserWhoWillFollow, String nameOfUserToFollow, UsersList usersList) throws Exception { //Completo
        if (nameOfUserWhoWillFollow == null || nameOfUserWhoWillFollow.trim().isEmpty() || nameOfUserToFollow == null || nameOfUserToFollow.trim().isEmpty()) {
            throw new Exception("Usuário inválido");
        }
        if (!usersList.hasUser(nameOfUserToFollow)){
            throw new Exception("O usuário que você quer seguir não está registrado");
        }
        Users userWhoWillFollow = usersList.getOneUser(nameOfUserWhoWillFollow, usersList);
        Users userToFollow = usersList.getOneUser(nameOfUserToFollow, usersList);
        if (userWhoWillFollow == userToFollow) {
            throw new Exception("Você não pode se seguir");
        }
        userWhoWillFollow.following.add(userToFollow);
    }

    /**
     * Método para mostrar o mural que vai aparecer para o usuário de acordo com os usuários que ele segue
     * @param usersList Lista de usuários onde estão os usuários que podem aparecer no mural
     * */
    public void showMural(UsersList usersList) {
        for (Users user : usersList.getUsers()){
            if (following.contains(user) || user.getName().equals(name)){
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
