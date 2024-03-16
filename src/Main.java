import Classes.Posts;
import Classes.Users;
import Classes.UsersList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int createUser = 1;
        final int makePost = 2;
        final int followUser = 3;
        final int showPostsFromUser = 4;
        final int seeFollows = 5;
        final int showMural = 6;
        final int exit = 7;
        int option;

        Users user = null;
        UsersList usersList = new UsersList();
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println(menu());
            option = sc.nextInt();

            if (option == createUser){
                sc.nextLine();
                System.out.println("Digite o nome de usuário da nova conta: ");
                String name = sc.nextLine();
                user = new Users(name, usersList);
                usersList.insertUser(user);
                System.out.println("Agora você está logado como " + user.toString());
            } else if (option == makePost) {
                sc.nextLine();
                if (usersList.getUsers() == null){
                    System.out.println("Você deve ter um usuário para poder postar algo.");
                    System.out.println("Digite o nome de usuário da nova conta: ");
                    String name = sc.nextLine();
                    user = new Users(name, usersList);
                }
                System.out.println("Digite o conteúdo da nova postagem.");
                System.out.print("> " + user.getName() + " -> ");
                String content = sc.nextLine();
                user.MakePost(content);
                System.out.println("Postado com sucesso no mural de " + user);
            } else if (option == followUser) {
                sc.nextLine();
                if (usersList.getUsers() == null){
                    System.out.println("Você deve ter um usuário para poder seguir alguém.");
                    System.out.println("Digite o nome de usuário da nova conta: ");
                    String name = sc.nextLine();
                    user = new Users(name, usersList);
                }
                System.out.println("Usuário que você quer seguir: ");
                String userToFollow = sc.nextLine();
                user.FollowUser(userToFollow, usersList);
                System.out.println("usuário seguido!");
            } else if (option == showPostsFromUser) {
                sc.nextLine();
                if (usersList.getUsers() == null){
                    System.out.println("Você deve ter um usuário para poder seguir alguém.");
                    System.out.println("Digite o nome de usuário da nova conta: ");
                    String name = sc.nextLine();
                    user = new Users(name, usersList);
                }
                System.out.println("Usuario para ver o mural: ");
                String userToShowMural = sc.nextLine();
                for (Posts post : usersList.showPostsFromUser(userToShowMural)) {
                    System.out.println("> " + user.getName() + " -> " + post);
                }
            } else if (option == seeFollows) {
                sc.nextLine();
                if (usersList.getUsers() == null){
                    System.out.println("Você deve ter um usuário para poder seguir alguém.");
                    System.out.println("Digite o nome de usuário da nova conta: ");
                    String name = sc.nextLine();
                    user = new Users(name, usersList);
                }
                System.out.println(user.getFollowing().toString());
            }

        }while (option != exit);

    }

    public static String menu(){
        return """
                Escolha uma das opções a seguir:
                1 - Criar novo usuário;
                2 - Postar;
                3 - Seguir usuário;
                4 - Ver postagens de um usuário;
                5 - Ver seguindos;
                6 - Ver mural;
                7 - Sair;""";
    }
}
