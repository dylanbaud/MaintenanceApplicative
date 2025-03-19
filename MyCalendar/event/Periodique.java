package event;

import user.User;

import java.time.LocalDateTime;

public class Periodique extends Event {
    public int frequenceJours;

    public Periodique(Title title, User owner, LocalDateTime dateDebut, Duration duration, int frequenceJours) {
        super(title, owner, dateDebut, duration);
        this.type = Type.PERIODIQUE;
        this.frequenceJours = frequenceJours;
    }

    public String description() {
        return "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
    }
}
