package GA.Project.Game;

import GA.Project.Players.CPU;
import GA.Project.Players.Character;
import GA.Project.Players.Human;

import java.util.Scanner;

public class RockPaperScissorsGame {

    private static Scanner choice = new Scanner(System.in);

    public static void play(){
        //need some exception handling for invalid input
        System.out.println("Do you want to play against a Computer or another person?\nType 'C' for computer or 'P' for person");
        String input = choice.nextLine().toLowerCase();

        if(input.equals("c")){
            playerVSCPU();
        }
        else if(input.equals("p")){
            playerVSPlayer();
        }
        else {
            System.out.println("Invalid entry, try again");
            play();

        }

    }


    public static void playerVSPlayer(){
        Character playerOne = new Human(); //Made Character for DRY-ness seen with battle function
        Character playerTwo = new Human();

        System.out.println("You have chosen Player vs. Player!\nEnter player 1's name: ");
        playerOne.setName(choice.nextLine());
        System.out.println("Enter player 2's name: ");
        playerTwo.setName(choice.nextLine());
        System.out.println("Your two players are: " + playerOne.getName() + " and " + playerTwo.getName());

        pvpBattle(playerOne, playerTwo);

    };

    public static void pvpBattle(Character p1, Character p2){
        System.out.println(p1.getName() + ", make a choice: rock, paper, scissors");
        p1.setChoice(p1.makeChoice());
        System.out.println(p2.getName() + ", make a choice: rock, paper, scissors");
        p2.setChoice(p2.makeChoice());

        if(!p1.getChoice().equals("rock") || !p1.getChoice().equals("paper") || !p1.getChoice().equals("scissors") || !p2.getChoice().equals("rock") || !p2.getChoice().equals("paper") || !p2.getChoice().equals("scissors")){
            System.out.println("A player made an invalid choice, go again");
            pvpBattle( p1, p2);
        }
        battle(p1.getChoice(), p2.getChoice(), p1, p2);

    }

    public static void playerVSCPU(){
        Character player = new Human();
        Character computer = new CPU();
        System.out.println("You have chosen Player vs. Computer!\nEnter your name: ");
        player.setName(choice.nextLine());
        System.out.println(player.getName() + " is going against the " + computer.getName());
        pvcBattle(player, computer);
    };

    public static void pvcBattle(Character player, Character cpu){
        System.out.println(player.getName() + ", make a choice: rock, paper, scissors");
        player.setChoice(player.makeChoice());
        cpu.setChoice(cpu.makeChoice());

        battle(player.getChoice(), cpu.getChoice(), player, cpu);

    }


    //make this return a string -- who won, their choice as well, and in main add the return of this func to an arraylist for history
    //also need to add invalid input exception
    public static void battle(String player1Move, String player2Move, Character player1, Character player2){
        System.out.println (player1.getName() + " has chosen " + player1Move + ", while " + player2.getName() + " has chosen " + player2Move);

        if(player1Move.equals(player2Move)){
            System.out.println("The same move was chosen");
        }
        else if ((player1Move.equals("rock") && player2Move.equals("paper")) || (player1Move.equals("scissors") && player2Move.equals("rock")) || (player1Move.equals("paper") && player2Move.equals("scissors"))){
            System.out.println( player2.getName() + " has won!");
        }
        else if ((player2Move.equals("rock") && player1Move.equals("paper")) || (player2Move.equals("scissors") && player1Move.equals("rock")) || (player2Move.equals("paper") && player1Move.equals("scissors"))){
            System.out.println( player1.getName() + " has won!");
        }

    }


    public static void menu() {
        System.out.println("MAIN MENU \n======\n 1. Type 'play' to  play \n 2. Type 'history' to view your game history.\n 3. Type 'quit' to stop playing. ");
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
                default:
                    System.out.println("Enter a valid option");
                    menu();
            }

    }


    public static void history() {
        System.out.println("in history successfully");

    }


    public static void quit() {
        System.out.println("in quit successfully");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Rock, Paper, Scissors!");
        menu();

        }

    }

