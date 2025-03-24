package event;

import java.time.LocalDateTime;
import java.util.List;

public class CalendarManager {
    public Events events;

    public CalendarManager() {
        this.events = new Events();
    }

    public void addEvent(Event e) {
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