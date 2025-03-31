package fr.dylan.calendarapp.event.meeting;

import fr.dylan.calendarapp.event.Duration;
import fr.dylan.calendarapp.event.Event;
import fr.dylan.calendarapp.event.Title;
import fr.dylan.calendarapp.user.User;

import java.time.LocalDateTime;

public class Meeting extends Event {
    public Place place;
    public Participants participants;

    public Meeting(Title title, User owner, LocalDateTime dateDebut, Duration duration, Place place, Participants participants) {
        super(title, owner, dateDebut, duration);
        this.place = place;
        this.participants = participants;
    }

    public String description() {
        return "Réunion : " + title + " à " + place + " avec " + participants + " (" + getId() + ")";
    }
}
