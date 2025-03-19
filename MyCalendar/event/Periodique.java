package event;

import user.User;

import java.time.LocalDateTime;

public class Periodique extends Event {
    public Frequence frequence;

    public Periodique(Title title, User owner, LocalDateTime dateDebut, Duration duration, Frequence frequence) {
        super(title, owner, dateDebut, duration);
        this.type = Type.PERIODIQUE;
        this.frequence = frequence;
    }

    public String description() {
        return "Événement périodique : " + title + " tous les " + frequence + " jours";
    }
}
