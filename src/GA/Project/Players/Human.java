package GA.Project.Players;

import java.util.Scanner;

public class Human extends Character {

    @Override
    public String makeChoice() {

        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();

        switch (choice.toLowerCase()) {
            case "rock":
                choice = this.choices[0];
                break;
            case "paper":
                choice = this.choices[1];
                break;
            case "scissors":
                choice = this.choices[2];
        }
        return choice;
    }
}
