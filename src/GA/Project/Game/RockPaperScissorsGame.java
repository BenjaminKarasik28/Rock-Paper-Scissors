package GA.Project.Game;

import GA.Project.Players.CPU;
import GA.Project.Players.Character;
import GA.Project.Players.Human;


import java.util.HashMap;

import java.util.Scanner;

public class RockPaperScissorsGame {

    private static Scanner choice = new Scanner(System.in);
    private static HashMap<String, Character>  players = new HashMap<>();



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

    public static void checkIfNameIsThere(String nameToCheck, Character player){
        boolean flag = false;
        while(!flag) {
            if (!players.containsKey(nameToCheck.toLowerCase())) {
                players.put(nameToCheck, player);
                flag = true;
            } else {
                System.out.println("This name is already in the database, choose a different one\nType a new name here:");
                nameToCheck = choice.nextLine();

            }
        }
        player.setName(nameToCheck);

    }


    public static void playerVSPlayer(){

        Character playerOne = new Human(); //Made Character for DRY-ness seen with battle function
        Character playerTwo = new Human();
        playerOne.listsInializier();
        playerTwo.listsInializier();


        System.out.println("You have chosen Player vs. Player!\nEnter player 1's name: ");
        String name = choice.nextLine();

        checkIfNameIsThere(name, playerOne);

        System.out.println("Enter player 2's name: ");
        name = choice.nextLine();

        checkIfNameIsThere(name, playerTwo);
        if(playerOne.getName().equals("") ){
            playerOne.setName("default Player One Name");
        }
        if(playerTwo.getName().equals("") ){
            playerTwo.setName("default Player Two Name");
        }

        System.out.println("Your two players are: " + playerOne.getName() + " and " + playerTwo.getName());

        pvpBattle(playerOne, playerTwo);

    };

    public static void pvpBattle(Character p1, Character p2){
        System.out.println("You have five attempts to choose a valid move");
        System.out.println(p1.getName() + ", make a choice: rock, paper, scissors");
        p1.setChoice(p1.makeChoice());
        System.out.println(p2.getName() + ", make a choice: rock, paper, scissors");
        p2.setChoice(p2.makeChoice());

        battle(p1.getChoice(), p2.getChoice(), p1, p2);

    }

    public static void playerVSCPU(){
        Character player = new Human();
        Character computer = new CPU();
        player.listsInializier();
        computer.listsInializier();
        players.put(computer.getName(), computer);

        System.out.println("You have chosen Player vs. Computer!\nEnter your name: ");
        String name = choice.nextLine();
        checkIfNameIsThere(name, player);

        if(player.getName().equals("")){
            player.setName("Default Player Name");
        }
        System.out.println(player.getName() + " is going against the " + computer.getName());
        pvcBattle(player, computer);
    };

    public static void pvcBattle(Character player, Character cpu){
        System.out.println("You have five attempts to choose a valid move");
        System.out.println(player.getName() + ", make a choice: rock, paper, scissors");
        player.setChoice(player.makeChoice());
        cpu.setChoice(cpu.makeChoice());

        battle(player.getChoice(), cpu.getChoice(), player, cpu);

    }

    public static void addToGameLogs(Character winner, Character loser, String winnerMove, String loserMove){
        winner.addTowWinGameLog(winner.getName() + " played: " + winnerMove + " and beat " + loser.getName() + ", who played " + loserMove);
        loser.addToLossGameLog(loser.getName() + " played: " + loserMove + " and lost to " + winner.getName() + ", who played " + winnerMove);

    }

    public static void battle(String player1Move, String player2Move, Character player1, Character player2){

        Scanner input = new Scanner(System.in);

            System.out.println(player1.getName() + " has chosen " + player1Move + ", while " + player2.getName() + " has chosen " + player2Move);

            if (player1Move.equals(player2Move)) {
                System.out.println("The same move was chosen");

            } else if ((player1Move.equals("rock") && player2Move.equals("paper")) || (player1Move.equals("scissors") && player2Move.equals("rock")) || (player1Move.equals("paper") && player2Move.equals("scissors"))) {

                System.out.println(player2.getName() + " has won!");

                player2.setWins(player2.getWins() + 1);

                addToGameLogs(player2, player1, player2Move, player1Move);

            } else if ((player2Move.equals("rock") && player1Move.equals("paper")) || (player2Move.equals("scissors") && player1Move.equals("rock")) || (player2Move.equals("paper") && player1Move.equals("scissors"))) {

                System.out.println(player1.getName() + " has won!");

                player1.setWins(player1.getWins() + 1);

                addToGameLogs(player1, player2, player1Move, player2Move);

            }

            System.out.println("Another round? Type: 'y' or 'n");
            String answer = input.nextLine();
            if(answer.toLowerCase().equals("y")){

                if(player2.getName().equals("CPU")){
                    pvcBattle(player1, player2);
                }
                else{
                    pvpBattle(player1, player2);
                }
            }
            else if (answer.toLowerCase().equals("n")){

                System.out.println("Results:" + "\n" + player1.getName()+ " has won " + player1.getWins() + " times" + "\n" + player2.getName()+ " has won " + player2.getWins() + " times" + "\nEnd of Match, going to MAIN MENU!");

                for (String s: player1.getLossGameLog()) {
                       System.out.println(s);
                }
                menu();
            }
            else{
                System.out.println("Invalid option entered, going to main menu");
                menu();

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


        System.out.println("To view a player's game logs, type their name");
        String name = choice.nextLine();

        if(players.containsKey(name)){
            System.out.println("WINS Log: ");
            if(players.get(name).getWinsGameLog().isEmpty()){
                System.out.println("No wins :(");
            }
            else {
                players.get(name).getWinsGameLog().forEach(log -> System.out.println(log));
            }
            System.out.println("LOSS log: ");

            if(players.get(name).getLossGameLog().isEmpty()){
                System.out.println("No losses :)");
            }
            else {
                players.get(name).getLossGameLog().forEach(log -> System.out.println(log));
            }
            System.out.println("Go to menu or history? \nType 'menu' for menu Or 'history' for history");
            String input = choice.nextLine();
            if (input.toLowerCase().equals("menu")){
                menu();
            }
            else if(input.toLowerCase().equals("history")) {
                history();
            }
            else {
                System.out.println("Invalid option entered, going to main menu");
                menu();
            }
        }
        else{
            System.out.println("This player hasn't played today, going to main menu");
            menu();
        }

    }

    public static void quit() {
        System.out.println("Thanks for playing! \nCopy Right: a Benjamin Karasik program");
    }

 }



