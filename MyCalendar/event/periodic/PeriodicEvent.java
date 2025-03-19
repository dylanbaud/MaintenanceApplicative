package event.periodic;

import event.Duration;
import event.Event;
import event.Title;
import user.User;

import java.time.LocalDateTime;

public class PeriodicEvent extends Event {
    public Frequency frequency;

    public PeriodicEvent(Title title, User owner, LocalDateTime dateDebut, Duration duration, Frequency frequency) {
        super(title, owner, dateDebut, duration);
        this.frequency = frequency;
    }

    public String description() {
        return "Événement périodique : " + title + " tous les " + frequency + " jours";
    }

    public boolean isInPeriod(LocalDateTime start, LocalDateTime end) {
        LocalDateTime occurrence = startDate;
        while (occurrence.isBefore(end)) {
            if (!occurrence.isBefore(start)) {
                return true;
            }
            occurrence = occurrence.plusDays(frequency.getDay());
        }
        return false;
    }
}
