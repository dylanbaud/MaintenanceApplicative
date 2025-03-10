package trivia;

import java.util.Objects;

public class Player {
    private final String name;
    private int place;
    private int purse;
    private boolean inPenaltyBox;

    public Player(String name) {
        this.name = name;
        this.place = 1;
        this.purse = 0;
        this.inPenaltyBox = false;
    }

    public String getName() {
        return name;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getPurse() {
        return purse;
    }

    public void setPurse(int purse) {
        this.purse = purse;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void setInPenaltyBox(boolean inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
    }

    @Override
    public String toString() {
        return name;
    }

    public void incrementPurse() {
        this.purse++;
    }


    public boolean didPlayerWin() {
        return getPurse() == 6;
    }
}
