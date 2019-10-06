package GA.Project.Game;


import java.io.IOException;
import java.util.Scanner;

public class RockPaperScissorsGame {

    private static Scanner choice = new Scanner(System.in);

    public static void play() {
        System.out.println("Do you want to play against a Computer or another person?\nType c for computer or p for person");
        String input = choice.nextLine().toLowerCase();

        if(input.equals("c")){

        }
    }

    public static void playerVSPlayer(){
        System.out.println("in pvp");
    };
    public static void playerVSCPU(){
        System.out.println("in pvc");
    };


    public static void menu() throws IOException {
        System.out.println("Welcome to Rock, Paper, Scissors! \nMAIN MENU \n======\n 1. Type 'play' to  play \n 2. Type 'history' to view your game history.\n 3. Type 'quit' to stop playing. ");
        String input = choice.nextLine().toLowerCase();

            switch (input){
                case "play":
                    play();
                    break;
                case "history":
                    history();
                    break;
                case "quit":
                    quit();
                    break;
                case "":
                    System.out.println("Enter a valid option");
            }

    }


    public static void history() {
        System.out.println("in history successfully");

    }


    public static void quit() {
        System.out.println("in quit successfully");
    }

    public static void main(String[] args) {
        try {
            menu();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
