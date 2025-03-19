package event;

import user.User;

import java.time.LocalDateTime;

public class Reunion extends Event {
    public String lieu;
    public String participants;

    public Reunion(Title title, User owner, LocalDateTime dateDebut, Duration duration, String lieu, String participants) {
        super(title, owner, dateDebut, duration);
        this.type = Type.REUNION;
        this.lieu = lieu;
        this.participants = participants;
    }

    public String description() {
        return "Réunion : " + title + " à " + lieu + " avec " + participants;
    }
}
