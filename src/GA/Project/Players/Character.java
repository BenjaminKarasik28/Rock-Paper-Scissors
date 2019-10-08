package GA.Project.Players;

import java.util.ArrayList;

public abstract class Character {

    protected String name;
    protected String [] choices = {"rock", "paper", "scissors"};
    protected String choice;
    protected int wins;
    protected ArrayList<String> winsGameLog;
    protected ArrayList<String> lossGameLog;

    public Character() {}

    public Character(String name, String[] choices, String choice, int wins, ArrayList<String> winsGameLog, ArrayList<String> lossGameLog) {
        this.name = name;
        this.choices = choices;
        this.choice = choice;
        this.wins = wins;
        this.winsGameLog = winsGameLog;
        this.lossGameLog = lossGameLog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getChoices() {
        return this.choices;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public ArrayList<String> getWinsGameLog() {
        return winsGameLog;
    }

    public void setWinsGameLog(ArrayList<String> winsGameLog) {
        this.winsGameLog = winsGameLog;
    }

    public ArrayList<String> getLossGameLog() {
        return lossGameLog;
    }

    public void setLossGameLog(ArrayList<String> lossGameLog) {
        this.lossGameLog = lossGameLog;
    }

    public abstract String makeChoice(); //returns something from choices either randomly if CPU or by user

    public void listsInializier(){ //initializes game log arrays
        lossGameLog=new ArrayList<>();
        winsGameLog=new ArrayList<>();
    }

    public void addTowWinGameLog(String s){

        winsGameLog.add(s);
    }
    public void addToLossGameLog(String s){
        lossGameLog.add(s);
    }



}
