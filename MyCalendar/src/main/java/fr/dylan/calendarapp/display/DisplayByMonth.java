package fr.dylan.calendarapp.display;

import fr.dylan.calendarapp.event.CalendarManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class DisplayByMonth extends DisplayAction {
    private final CalendarManager calendar;

    public DisplayByMonth(CalendarManager calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'année (AAAA) : ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int month = Integer.parseInt(scanner.nextLine());

        LocalDateTime startMonth = LocalDateTime.of(year, month, 1, 0, 0);
        LocalDateTime endMonth = startMonth.plusMonths(1).minusSeconds(1);

        displayEventsList(calendar.eventsInPeriod(startMonth, endMonth));
    }

    @Override
    public String getName() {
        return "Afficher les événements d'un MOIS précis";
    }
}
