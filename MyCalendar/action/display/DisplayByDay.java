package action.display;

import event.CalendarManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class DisplayByDay extends DisplayAction {
    private final CalendarManager calendar;

    public DisplayByDay(CalendarManager calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'année (AAAA) : ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le jour (1-31) : ");
        int day = Integer.parseInt(scanner.nextLine());

        LocalDateTime startDay = LocalDateTime.of(year, month, day, 0, 0);
        LocalDateTime endDay = startDay.plusDays(1).minusSeconds(1);

        displayEventsList(calendar.eventsInPeriod(startDay, endDay));
    }

    @Override
    public String getName() {
        return "Afficher les événements d'un JOUR précis";
    }
}
