package Main;

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

            if (option == createUser){
                sc.nextLine();
                System.out.print("Nome de usuário da nova conta: > ");
                String myUser = sc.nextLine();
                try {
                    user = new Users(myUser, usersList);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    System.out.print("Digite outro nome de usuário: > ");
                    myUser = sc.nextLine();
                    user = new Users(myUser, usersList);
                }
                usersList.insertUser(user);
                System.out.println("Novo usuário " + user.getName() + " criado com sucesso");
                System.out.println();
            } else if (option == makePost) {
                sc.nextLine();
                System.out.print("Meu usuário: > ");
                String myUser = sc.nextLine();
                try {
                    user = usersList.getOneUser(myUser, usersList);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.print("Digite o novo nome de usuário: > ");
                    myUser = sc.nextLine();
                    user = new Users(myUser, usersList);
                    usersList.insertUser(user);
                }
                System.out.print("Conteúdo da nova postagem: -> ");
                String content = sc.nextLine();
                try {
                    user.makePost(myUser, content, usersList);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.print("Conteúdo da nova postagem: -> ");
                    content = sc.nextLine();
                    user.makePost(myUser, content, usersList);
                }
                System.out.println("Postado com sucesso no mural de " + user.getName());
                System.out.println();
            } else if (option == followUser) {
                sc.nextLine();
                System.out.print("Meu usuário: > ");
                String myUser = sc.nextLine();
                try {
                    user = usersList.getOneUser(myUser, usersList);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    System.out.print("Nome de usuário da nova conta: > ");
                    myUser = sc.nextLine();
                    user = new Users(myUser, usersList);
                    usersList.insertUser(user);
                }
                System.out.print("Usuário que você quer seguir: > ");
                String userNameToFollow = sc.nextLine();
                try {
                    user.followUser(myUser, userNameToFollow, usersList);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    System.out.print("Usuário que você quer seguir: > ");
                    userNameToFollow = sc.nextLine();
                    user.followUser(myUser, userNameToFollow, usersList);
                }
                System.out.println(user.getName() + " agora segue " + userNameToFollow);
                System.out.println();
            } else if (option == showPostsFromUser) {
                sc.nextLine();
                System.out.print("Usuário para ver o mural: > ");
                String userToShowMural = sc.nextLine();
                try {
                    System.out.println(usersList.showPostsFromUser(userToShowMural, usersList));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.print("Usuário para ver o mural: > ");
                    userToShowMural = sc.nextLine();
                    System.out.println(usersList.showPostsFromUser(userToShowMural, usersList));
                }
            } else if (option == seeFollows) {
                sc.nextLine();
                System.out.print("Meu usuário: > ");
                String myUser = sc.nextLine();
                try{
                    user = usersList.getOneUser(myUser, usersList);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    System.out.print("Nome de usuário da nova conta: > ");
                    myUser = sc.nextLine();
                    user = new Users(myUser, usersList);
                    usersList.insertUser(user);
                }
                System.out.println("Usuários que você segue: \n" + user.showFollowing());
                System.out.println();
            } else if (option == showMural) {
                sc.nextLine();
                System.out.print("Meu usuário: > ");
                String myUser = sc.nextLine();
                try {
                    user = usersList.getOneUser(myUser, usersList);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.print("Nome de usuário da nova conta: > ");
                    myUser = sc.nextLine();
                    user = new Users(myUser, usersList);
                    usersList.insertUser(user);
                }
                System.out.println();
                System.out.println("Mural de " + user.getName() + ": \n");
                System.out.println(user.showMural(usersList));;
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
