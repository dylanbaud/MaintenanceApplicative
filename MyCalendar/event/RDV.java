package event;

import user.User;

import java.time.LocalDateTime;

public class RDV extends Event {

    public RDV(Title title, User owner, LocalDateTime dateDebut, Duration duration) {
        super(title, owner, dateDebut, duration);
        this.type = Type.RDV_PERSONNEL;
    }

    public String description() {
        return "RDV : " + title + " à " + dateDebut.toString();
    }
}
