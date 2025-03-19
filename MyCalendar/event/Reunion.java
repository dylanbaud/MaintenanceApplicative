package event;

import user.User;

import java.time.LocalDateTime;
import java.util.List;

public class Reunion extends Event {
    public Lieu lieu;
    public List<Participant> participants;

    public Reunion(Title title, User owner, LocalDateTime dateDebut, Duration duration, Lieu lieu, List<Participant> participants) {
        super(title, owner, dateDebut, duration);
        this.type = Type.REUNION;
        this.lieu = lieu;
        this.participants = participants;
    }

    public String description() {
        return "Réunion : " + title + " à " + lieu + " avec " + participants;
    }
}
