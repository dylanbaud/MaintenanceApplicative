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

}
