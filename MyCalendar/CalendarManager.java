import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    public List<Event> events;

    public CalendarManager() {
        this.events = new ArrayList<>();
    }

    public void ajouterEvent(Type type, Title title, Utilisateur proprietaire, LocalDateTime dateDebut, Duree duree,
                             String lieu, String participants, int frequenceJours) {
        Event e = new Event(type, title, proprietaire, dateDebut, duree, lieu, participants, frequenceJours);
        events.add(e);
    }

    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();
        for (Event e : events) {
            if (e.type.equals(Type.PERIODIQUE)) {
                LocalDateTime temp = e.dateDebut;
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.add(e);
                        break;
                    }
                    temp = temp.plusDays(e.frequenceJours);
                }
            } else if (!e.dateDebut.isBefore(debut) && !e.dateDebut.isAfter(fin)) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1 = e1.dateDebut.plusMinutes(e1.duree.getMinutes());
        LocalDateTime fin2 = e2.dateDebut.plusMinutes(e2.duree.getMinutes());

        if (e1.type.equals(Type.PERIODIQUE) || e2.type.equals(Type.PERIODIQUE)) {
            return false; // Simplification abusive
        }

        return e1.dateDebut.isBefore(fin2) && fin1.isAfter(e2.dateDebut);
    }

    public void afficherEvenements() {
        for (Event e : events) {
            System.out.println(e.description());
        }
    }
}