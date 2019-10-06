package GA.Project.Game;

import java.util.Scanner;

public class RockPaperScissorsGame implements Game {

    private Scanner menuChoice = new Scanner(System.in);
    @Override
    public void play() {

    }

    @Override
    public void menu() {
        System.out.println("Welcome to Rock, Paper, Scissors! \nMAIN MENU \n====\n 1. Type: 'play' to  play \n 2. ");



        String input = menuChoice.nextLine();


    }

    @Override
    public void history() {

    }

    @Override
    public void quit() {

    }

}
