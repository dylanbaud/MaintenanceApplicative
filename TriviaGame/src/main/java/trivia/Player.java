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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return place == player.place && purse == player.purse && inPenaltyBox == player.inPenaltyBox && Objects.equals(name, player.name);
    }

    public void movePlayer(int roll) {
        setPlace(getPlace() + roll);
        if (getPlace() > 12)
            setPlace(getPlace() - 12);

        System.out.println(name
                + "'s new location is "
                + getPlace());
    }

    public boolean didPlayerWin() {
        return getPurse() == 6;
    }
}
