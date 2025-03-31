package fr.dylan.calendarapp.event.meeting;

public class Participant {

    private final String firstName;

    public Participant(String firstName) {
        this.firstName = firstName;
    }

    public String toString() {
        return firstName;
    }
}
