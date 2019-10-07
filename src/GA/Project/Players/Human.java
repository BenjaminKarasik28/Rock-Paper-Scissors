package GA.Project.Players;

import java.util.Scanner;

public class Human extends Character {



    @Override
    public String makeChoice() {

        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();



//        while(flag){
//            System.out.println(incorrectAttempts);
//            if(choice.toLowerCase().equals("rock")){
//                choice = this.choices[0];
//                flag=true;
//            }
//            else if(choice.toLowerCase().equals("paper")){
//                choice = this.choices[1];
//                flag=true;
//            }
//            else if(choice.toLowerCase().equals("scissors")){
//                choice = this.choices[2];
//                flag=true;
//            }
//            else{
//                System.out.println("Invalid option, choose again:");
//
//                incorrectAttempts++;
//                System.out.println(incorrectAttempts);
//            }
//        }

            switch (choice.toLowerCase()) {
                case "rock":
                    choice = this.choices[0];

                    break;
                case "paper":
                    choice = this.choices[1];

                    break;
                case "scissors":
                    choice = this.choices[2];

                    break;
                default:
                    System.out.println("Invalid option, choose again:");
            }
        return choice;
    }
}
