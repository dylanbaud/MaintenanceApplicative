package event;

import user.User;

import java.time.LocalDateTime;

public abstract class Event {
    public Title title;
    public User owner;
    public LocalDateTime startDate;
    public Duration duration;

    public Event(Title title, User owner, LocalDateTime startDate, Duration duration) {
        this.title = title;
        this.owner = owner;
        this.startDate = startDate;
        this.duration = duration;
    }

    public abstract String description();

    public boolean isInPeriod(LocalDateTime start, LocalDateTime end) {
        return !startDate.isBefore(start) && !startDate.isAfter(end);
    }

}