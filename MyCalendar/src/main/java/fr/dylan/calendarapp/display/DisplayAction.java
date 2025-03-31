package fr.dylan.calendarapp.display;

import fr.dylan.calendarapp.action.Action;
import fr.dylan.calendarapp.event.Event;

import java.util.List;

public abstract class DisplayAction implements Action {

    public void displayEventsList(List<Event> events) {
        if (events.isEmpty()) {
            System.out.println("Aucun événement trouvé pour cette période.");
        } else {
            System.out.println("Événements trouvés : ");
            for (Event e : events) {
                System.out.println("- " + e.description());
            }
        }
    }
}
