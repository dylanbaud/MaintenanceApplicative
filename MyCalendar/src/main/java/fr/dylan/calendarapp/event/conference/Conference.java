package fr.dylan.calendarapp.event.conference;

import fr.dylan.calendarapp.event.Duration;
import fr.dylan.calendarapp.event.Event;
import fr.dylan.calendarapp.event.Title;
import fr.dylan.calendarapp.user.User;

import java.time.LocalDateTime;

public class Conference extends Event {
    private final Topic topic;
    private final Speaker speaker;

    public Conference(Title title, User owner, LocalDateTime startDate, Duration duration, Topic topic, Speaker speaker) {
        super(title, owner, startDate, duration);
        this.topic = topic;
        this.speaker = speaker;
    }
    @Override
    public String description() {
        return "Conférence sur " + topic + " par " + speaker;
    }
}