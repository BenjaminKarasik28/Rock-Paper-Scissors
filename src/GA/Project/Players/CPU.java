package GA.Project.Players;

import java.util.Random;

public class CPU extends Character {
    private Random choiceGenerator;

    public CPU(){
        this.name = "CPU";
    }
    @Override
    public String makeChoice() throws ArrayIndexOutOfBoundsException {
        choiceGenerator = new Random();
        int index = choiceGenerator.nextInt(choices.length);
        return choices[index];

    }
}
