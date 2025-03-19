package event;

import java.util.ArrayList;
import java.util.List;

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

    public void removeEvent(Event e) {
        events.remove(e);
    }

}
