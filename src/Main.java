import Classes.Posts;
import Classes.Users;
import Classes.UsersList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int createUser = 1;
        final int makePost = 2;
        final int followUser = 3;
        final int showPosts = 4;
        final int seeFollows = 5;
        final int exit = 6;
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
                if (user == null){
                    System.out.println("Você deve ter um usuário para poder postar algo");
                    System.out.println("Digite o nome de usuário da nova conta: ");
                    String name = sc.nextLine();
                    user = new Users(name, usersList);
                }
                System.out.println("Digite o conteúdo da nova postagem");
                String content = sc.nextLine();
                user.MakePost(content);
                System.out.println("Postado com sucesso");
            } else if (option == followUser) {
                sc.nextLine();
                System.out.println("Usuário que você quer seguir: ");
                String userToFollow = sc.nextLine();
                user.FollowUser(userToFollow, usersList);
            } else if (option == showPosts) {
                sc.nextLine();
                System.out.println("Usuario para ver o mural: ");
                String userToShowMural = sc.nextLine();
                System.out.println(usersList.showPosts(userToShowMural));
            } else if (option == seeFollows) {
                sc.nextLine();
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
                4 - Ver mural;
                5 - Ver seguindos;
                6 - Sair;""";
    }
}
