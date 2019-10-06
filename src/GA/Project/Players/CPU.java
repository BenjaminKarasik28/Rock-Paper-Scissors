package GA.Project.Players;

public class CPU extends Character {

    public CPU(String name){
        this.name = "CPU";
    }
    @Override
    public String makeChoice() {
        return null;
    }


    @Override
    public String getName(){
        return "CPU";
    }
}
