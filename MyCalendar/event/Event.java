package event;

import user.User;

import java.time.LocalDateTime;

public abstract class Event {
    public Title title;
    public User owner;
    public LocalDateTime dateDebut;
    public Duration duration;

    public Event(Title title, User owner, LocalDateTime dateDebut, Duration duration) {
        this.title = title;
        this.owner = owner;
        this.dateDebut = dateDebut;
        this.duration = duration;
    }

    public abstract String description();
}