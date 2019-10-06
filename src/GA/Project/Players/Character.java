package GA.Project.Players;

public abstract class Character {
    protected int lives;
    protected String name;
    protected String [] choices = {"rock", "paper", "scissors"};

    public Character() {}

    public Character(int lives, String[] choices, String name) {
        this.lives = lives;
        this.choices = choices;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    protected abstract String makeChoice(); //returns something from choices either randomly if CPU or by user




}
