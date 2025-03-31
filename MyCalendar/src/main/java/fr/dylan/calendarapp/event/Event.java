package fr.dylan.calendarapp.event;

import fr.dylan.calendarapp.user.User;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Event {
    private final UUID id;
    public Title title;
    public User owner;
    public LocalDateTime startDate;
    public Duration duration;

    public Event(Title title, User owner, LocalDateTime startDate, Duration duration) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.owner = owner;
        this.startDate = startDate;
        this.duration = duration;
    }

    public UUID getId() {
        return id;
    }

    public abstract String description();

    public boolean isInPeriod(LocalDateTime start, LocalDateTime end) {
        return !startDate.isBefore(start) && !startDate.isAfter(end);
    }

    public boolean overlapsWith(Event other) {
        LocalDateTime thisEnd = this.startDate.plus(this.duration.toPeriod());
        LocalDateTime otherEnd = other.startDate.plus(other.duration.toPeriod());
        return this.startDate.isBefore(otherEnd) && thisEnd.isAfter(other.startDate);
    }
}