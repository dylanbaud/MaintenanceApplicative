package fr.dylan.calendarapp.event;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Events {

    private final List<Event> events;

    public Events() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event e) {
        events.add(e);
    }

    public List<Event> getEvents() {
        return events;
    }

    public void removeEvent(UUID uuid) {
        events.removeIf(event -> event.getId().equals(uuid));
    }

    public Event getEvent(UUID uuid) {
        for (Event event : events) {
            if (event.getId().equals(uuid)) {
                return event;
            }
        }
        return null;
    }

}
