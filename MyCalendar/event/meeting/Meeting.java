package event.meeting;

import event.*;
import user.User;

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
        return "Réunion : " + title + " à " + place + " avec " + participants;
    }
}
