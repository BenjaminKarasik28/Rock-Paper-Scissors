package GA.Project.Players;

public abstract class Character {

    protected String name;
    protected String [] choices ={"rock", "paper", "scissors"};
    String choice;

    public Character() {}

    public Character( String[] choices, String name, String choice) {

        this.choices = choices;
        this.name = name;
        this.choice = choice;
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

    public abstract String makeChoice(); //returns something from choices either randomly if CPU or by user




}
