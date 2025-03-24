package action.display;

import event.CalendarManager;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class DisplayByWeek extends DisplayAction {
    private final CalendarManager calendar;

    public DisplayByWeek(CalendarManager calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'année (AAAA) : ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le numéro de semaine (1-52) : ");
        int week = Integer.parseInt(scanner.nextLine());

        LocalDateTime startWeek = LocalDateTime.now()
                .withYear(year)
                .with(WeekFields.of(Locale.FRANCE).weekOfYear(), week)
                .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                .withHour(0).withMinute(0);
        LocalDateTime endWeek = startWeek.plusDays(7).minusSeconds(1);

        displayEventsList(calendar.eventsInPeriod(startWeek, endWeek));
    }

    @Override
    public String getName() {
        return "Afficher les événements d'une SEMAINE précise";
    }
}
