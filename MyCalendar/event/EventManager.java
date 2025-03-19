package event;

import event.periodic.PeriodicEvent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventManager {
    public Events events;

    public EventManager() {
        this.events = new Events();
    }

    public void ajouterEvent(Event e) {
        events.addEvent(e);
    }

    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();
        for (Event e : events.getEvents()) {
            if (e instanceof PeriodicEvent periodicEvent) {
                LocalDateTime temp = periodicEvent.dateDebut;
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.add(periodicEvent);
                        break;
                    }
                    temp = temp.plusDays(periodicEvent.frequence.getDay());
                }
            } else if (!e.dateDebut.isBefore(debut) && !e.dateDebut.isAfter(fin)) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1 = e1.dateDebut.plusMinutes(e1.duration.getMinutes());
        LocalDateTime fin2 = e2.dateDebut.plusMinutes(e2.duration.getMinutes());

        if (e1 instanceof PeriodicEvent || e2 instanceof PeriodicEvent) {
            return false; // Simplification abusive
        }

        return e1.dateDebut.isBefore(fin2) && fin1.isAfter(e2.dateDebut);
    }

    public void afficherEvenements() {
        for (Event e : events.getEvents()) {
            System.out.println(e.description());
        }
    }
}