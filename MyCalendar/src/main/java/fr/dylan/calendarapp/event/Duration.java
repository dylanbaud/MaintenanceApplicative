package fr.dylan.calendarapp.event;

import java.time.Period;

public class Duration {

    private int minutes;

    public Duration(int minutes) {
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public Period toPeriod() {
        return Period.ofDays(minutes / (24 * 60));
    }
}