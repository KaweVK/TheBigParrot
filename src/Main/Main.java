package Main;

import Classes.Posts;
import Classes.Users;
import Classes.UsersList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        final int createUser = 1;
        final int makePost = 2;
        final int followUser = 3;
        final int showPostsFromUser = 4;
        final int seeFollows = 5;
        final int showMural = 6;
        final int exit = 7;
        int option;

        Users user;
        UsersList usersList = new UsersList();
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                =================================
                Bem vindo ao Grande Papagaio""");
        do{
            System.out.println(menu());
            option = sc.nextInt();

            if (option == createUser){ //completo
                sc.nextLine();
                System.out.println("Nome de usuário da nova conta: > ");
                String myUser = sc.nextLine();
                try {
                    user = new Users(myUser, usersList);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    System.out.println("Escolha outro nome de usuário: > ");
                    myUser = sc.nextLine();
                    user = new Users(myUser, usersList);
                }
                usersList.insertUser(user);
                System.out.println("Novo usuário " + user.getName() + " criado com sucesso");
            } else if (option == makePost) {
                sc.nextLine();
                System.out.print("Meu usuário: > ");
                String myUser = sc.nextLine();
                if (!usersList.hasUser(myUser)){
                    System.out.println("Você deve ter um usuário para poder postar algo.");
                    System.out.println("Nome de usuário da nova conta: > ");
                    myUser = sc.nextLine();
                    user = new Users(myUser, usersList);
                    usersList.insertUser(user);
                } else {
                    user = usersList.getOneUser(myUser, usersList);
                }
                System.out.print("Conteúdo da nova postagem: ->");
                String content = sc.nextLine();
                try {
                    user.makePost(myUser, content, usersList);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println();
                    System.out.print("Conteúdo da nova postagem: ->");
                    content = sc.nextLine();
                    user.makePost(myUser, content, usersList);
                }

                System.out.println("Postado com sucesso no mural de " + user.getName());
            } else if (option == followUser) { //acho que tá em 90%
                sc.nextLine();
                System.out.print("Meu usuário: > ");
                String myUser = sc.nextLine();
                try {
                    user = usersList.getOneUser(myUser, usersList);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    System.out.println();
                    System.out.println("Nome de usuário da nova conta: > ");
                    myUser = sc.nextLine();
                    user = new Users(myUser, usersList);
                    usersList.insertUser(user);
                }
                System.out.print("Usuário que você quer seguir: > ");
                String userNameToFollow = sc.nextLine();
                try {
                    user.followUser(myUser, userNameToFollow, usersList);
                    System.out.println(user.getName() + " agora segue " + userNameToFollow);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    System.out.println("Tente seguir um usuário válido");
                }
            } else if (option == showPostsFromUser) { //completo 98% falta só trocar as escritas
                sc.nextLine();
                System.out.println("Usuario para ver o mural: ");
                String userToShowMural = sc.nextLine();
                user = usersList.getOneUser(userToShowMural, usersList);
                for (Posts post : user.getPosts()) {
                    System.out.println("> " + user.getName() + " -> " + post);
                }
            } else if (option == seeFollows) { //loop infinito
                sc.nextLine();
                System.out.print("Meu usuário: > ");
                String myUser = sc.nextLine();
                try{
                    user = usersList.getOneUser(myUser, usersList);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    System.out.println("Digite o nome de usuário da nova conta: ");
                    myUser = sc.nextLine();
                    user = new Users(myUser, usersList);
                    usersList.insertUser(user);
                }
                System.out.println("Usuários que você segue: " + user.getFollowing());
            } else if (option == showMural) {
                sc.nextLine();
                System.out.println("Meu usuário: > ");
                String myUser = sc.nextLine();
                if (!usersList.hasUser(myUser)){
                    System.out.println("Você deve ter um usuário para poder postar algo.");
                    System.out.println("Digite o nome de usuário da nova conta: ");
                    myUser = sc.nextLine();
                    user = new Users(myUser, usersList);
                    usersList.insertUser(user);
                } else {
                    user = usersList.getOneUser(myUser, usersList);
                }
                user.showMural(usersList);
            }

        }while (option != exit);

        System.out.println("Até mais!");

    }

    public static String menu(){
        return """
                =================================
                Escolha uma das opções a seguir:
                =================================
                1 - Criar novo usuário;
                2 - Publicar;
                3 - Seguir usuário;
                4 - Ver postagens de um usuário;
                5 - Ver seguindos;
                6 - Ver mural geral;
                7 - Sair;""";
    }
}