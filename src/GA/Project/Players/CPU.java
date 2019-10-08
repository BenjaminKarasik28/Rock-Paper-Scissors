package GA.Project.Players;

import java.util.Random;

public class CPU extends Character {

    public CPU(){
        this.name = "CPU";
    }
    /*
    * CPU returns random choice
    * */
    @Override
    public String makeChoice() throws ArrayIndexOutOfBoundsException {
        Random  choiceGenerator = new Random();
        int index = choiceGenerator.nextInt(choices.length);
        return choices[index];

    }
}
