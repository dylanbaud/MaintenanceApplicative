package event;

public class Frequence {

    private int day;

    public Frequence(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String toString() {
        return day + "";
    }
}
