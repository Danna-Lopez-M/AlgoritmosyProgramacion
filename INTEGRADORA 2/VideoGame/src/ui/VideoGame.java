package ui;

import model.VideoGameController;
import java.util.Scanner;

public class VideoGame{

    public static Scanner sc = new Scanner(System.in);
    public static VideoGameController videoController = new VideoGameController();

    public static void main(String[] args){

        menu();

    }
        
    public static void menu(){
        System.out.println("Welcome");
        boolean exit = false;

        while(!exit){
            System.out.println("Type an option\n1.Player\n2.Exit");

            int option = sc.nextInt();

            switch(option){
                case 1:
                    menuPlayer();
                    break;
                default:
                    System.out.println("Bye bye");
                    exit = true;
                    break;
            }
        }
    }

    public static void menuPlayer(){
        System.out.println("Welcome");
        boolean exit = false;

        while(!exit){
            System.out.println("Type an option\n1. Register a player\n2.Show players\n3.Go back menu");

            int option = sc.nextInt();

            switch(option){
                case 1:
                    registerPlayer();
                    break;
                case 2:
                    System.out.println(videoController.showPlayer());
                    break;
                case 3:
                    System.out.println("Returning to the menu\n ");
                    exit = true;
                    break;
            }
        }
    }

    private static void registerPlayer(){
        System.out.println("Type the nickname");
        sc.nextLine();
        String nickname = sc.nextLine();

        System.out.println("Type the name");
        String name = sc.nextLine();

        if (videoController.registerPlayer(nickname, name)){
            System.out.println("Registered player\n ");
        }
        else{
            System.out.println("Error \n ");

        }
    }
}
