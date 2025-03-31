package fr.dylan.calendarapp.event.periodic;

public class Frequency {

    private int day;

    public Frequency(int day) {
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
