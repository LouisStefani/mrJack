package mrjack;

import java.util.ArrayList;

public class Player {
    private String role;
    private ArrayList<Jeton> jetons;

    public Player(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public ArrayList<Jeton> getJetons() {
        return jetons;
    }

    public void setJetons(ArrayList<Jeton> jetons) {
        this.jetons = jetons;
    }

}