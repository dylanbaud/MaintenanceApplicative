package fr.dylan.calendarapp.event;

import java.time.LocalDateTime;
import java.util.List;

public class CalendarManager {
    public Events events;

    public CalendarManager() {
        this.events = new Events();
    }

    public void addEvent(Event e) {
        for (Event existingEvent : events.getEvents()) {
            if (existingEvent.overlapsWith(e)) {
                throw new IllegalArgumentException("Conflit détecté avec un événement existant.");
            }
        }
        events.addEvent(e);
    }

    public List<Event> eventsInPeriod(LocalDateTime start, LocalDateTime end) {
        return events.getEvents().stream()
                .filter(e -> e.isInPeriod(start, end))
                .toList();
    }

    public void displayEvents() {
        for (Event e : events.getEvents()) {
            System.out.println(e.description());
        }
    }
}