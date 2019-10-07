package GA.Project.Players;

public abstract class Character {

    protected String name;
    protected String [] choices ={"rock", "paper", "scissors"};
    String choice;
    int wins;

    public Character() {}

    public Character( String[] choices, String name, String choice, int wins) {

        this.choices = choices;
        this.name = name;
        this.choice = choice;
        this.wins = 0;
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

    public abstract String makeChoice(); //returns something from choices either randomly if CPU or by user




}
