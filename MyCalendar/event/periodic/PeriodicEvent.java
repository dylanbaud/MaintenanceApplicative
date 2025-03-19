package event.periodic;

import event.Duration;
import event.Event;
import event.Title;
import user.User;

import java.time.LocalDateTime;

public class PeriodicEvent extends Event {
    public Frequence frequence;

    public PeriodicEvent(Title title, User owner, LocalDateTime dateDebut, Duration duration, Frequence frequence) {
        super(title, owner, dateDebut, duration);
        this.frequence = frequence;
    }

    public String description() {
        return "Événement périodique : " + title + " tous les " + frequence + " jours";
    }
}
