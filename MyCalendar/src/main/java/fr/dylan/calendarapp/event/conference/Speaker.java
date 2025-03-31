package fr.dylan.calendarapp.event.conference;

public class Speaker {

    private final String firstName;

    public Speaker(String firstName) {
        this.firstName = firstName;
    }

    public String toString() {
        return firstName;
    }
}
