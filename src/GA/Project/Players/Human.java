package GA.Project.Players;

import GA.Project.Game.RockPaperScissorsGame;

import java.util.Scanner;

public class Human extends Character {



    @Override
    public String makeChoice() {

        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        int counter=0;
        while(counter < 4){


            if(!choice.toLowerCase().equals("rock") && !choice.toLowerCase().equals("paper") && !choice.toLowerCase().equals("scissors")) {
                System.out.println("Invalid entry");
                counter++;
                System.out.println("Try again:");
                choice = input.nextLine();
                if(counter==4){
                    System.out.println("Invalid moves chosen more than 4 times, going to main menu");
                    RockPaperScissorsGame.menu();
                }

            }
            else {
                 if (choice.toLowerCase().equals("rock")) {
                    choice = this.choices[0];
                    counter = 4;
                } else if (choice.toLowerCase().equals("paper")) {
                    choice = this.choices[1];
                    counter = 4;
                } else if (choice.toLowerCase().equals("scissors")) {
                    choice = this.choices[2];
                    counter = 4;
                }
            }
        }
        return choice;
    }
}

