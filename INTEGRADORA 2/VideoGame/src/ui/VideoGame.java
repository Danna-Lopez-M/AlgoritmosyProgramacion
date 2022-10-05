package ui;

import model.VideoGameController;
import java.util.Scanner;
import java.util.Random;

public class VideoGame{

    public static Scanner sc = new Scanner(System.in);
    public static Random rd = new Random();
    public static VideoGameController videoController = new VideoGameController();

    public static void main(String[] args){
        createdLvl();
        menu();


    }

    public static void createdLvl(){
        int score=0;
        boolean control= true;

        for (int i=0; i<10; i++){
            score += rd.nextInt(100);
            control = control && videoController.createdLvl(i+1, score);
        }

        if(control){
            System.out.println("The levels was created successful");
        }
        else{
            System.out.println("Error");
            System.exit(0);
        }
    }
        
    public static void menu(){
        System.out.println("Welcome");
        boolean exit = false;

        while(!exit){
            System.out.println("Type an option\n1.Player\n2.Enemy\n3. Exit");

            int option = sc.nextInt();

            switch(option){
                case 1:
                    menuPlayer();
                    break;
                case 2:
                    menuEnemy();
                    break;
                default:
                    System.out.println("Bye bye");
                    exit = true;
                    break;
            }
        }
    }

    public static void menuPlayer(){
        boolean exit = false;

        while(!exit){
            System.out.println("Type an option\n1. Register a player"+
            "\n2.Show players\n3.Go back menu");

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

    public static void menuEnemy(){
        boolean exit = false;

        while(!exit){
            System.out.println("Type an option\n1. Register a enemy\n2. Show enemies"+
            "\n3. Add enemy to a level\n4.Go back menu");

            int option = sc.nextInt();

            switch(option){
                case 1:
                    registerEnemy();
                    break;
                case 2:
                    System.out.println(videoController.showEnemy());
                    break;
                case 3:
                    addEnemytolevel();
                    break;
                case 4:
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

    private static void registerEnemy(){
        System.out.println("Type the name");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.println("Enter the type of enemy");
        System.out.println(videoController.showTEnm());
        int type = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter a score to subtra when beat a player");
        int subtrScr = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter a score to sum when lose against a player");
        int sumScr = sc.nextInt();
        sc.nextLine();

        if (videoController.registerEnemy(name, type,subtrScr,sumScr)){
            System.out.println("Registered enemy successful\n ");
        }
        else{
            System.out.println("Error \n ");

        }
    }

    public static void addEnemytolevel() {
		System.out.println("Select the number/name of the Level that you want to add a enemy to");
		System.out.println(videoController.showLevel());
		int selLvl = sc.nextInt();
        sc.nextLine();

		System.out.println("Select the NAME of the Enemy to add");
		System.out.println(videoController.showEnemy());
		String selEne = sc.nextLine();

		System.out.println(videoController.addEnemyToLevel(selEne, selLvl));

	}

}
