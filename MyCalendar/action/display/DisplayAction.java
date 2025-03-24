package action.display;

import event.Event;
import action.Action;

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
