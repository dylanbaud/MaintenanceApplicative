package event;

import user.User;

import java.time.LocalDateTime;

public class PersonalAppointment extends Event {

    public PersonalAppointment(Title title, User owner, LocalDateTime dateDebut, Duration duration) {
        super(title, owner, dateDebut, duration);
    }

    public String description() {
        return "RDV : " + title + " à " + startDate.toString();
    }
}
