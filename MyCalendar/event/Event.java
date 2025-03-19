package event;

import user.User;

import java.time.LocalDateTime;

public class Event {
    public Type type;
    public Title title;
    public User owner;
    public LocalDateTime dateDebut;
    public Duration duration;
    public String lieu; // utilisé seulement pour REUNION
    public String participants; // séparés par virgules (pour REUNION uniquement)
    public int frequenceJours; // uniquement pour PERIODIQUE

    public Event(Type type, Title title, User owner, LocalDateTime dateDebut, Duration duration,
                 String lieu, String participants, int frequenceJours) {
        this.type = type;
        this.title = title;
        this.owner = owner;
        this.dateDebut = dateDebut;
        this.duration = duration;
        this.lieu = lieu;
        this.participants = participants;
        this.frequenceJours = frequenceJours;
    }

    public String description() {
        String desc = "";
        if (type.equals(Type.RDV_PERSONNEL)) {
            desc = "RDV : " + title + " à " + dateDebut.toString();
        } else if (type.equals(Type.REUNION)) {
            desc = "Réunion : " + title + " à " + lieu + " avec " + participants;
        } else if (type.equals(Type.PERIODIQUE)) {
            desc = "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
        }
        return desc;
    }
}