package action.logged;

import action.Action;
import event.CalendarManager;
import user.UserManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public abstract class AddEvent implements Action {
    protected final UserManager userManager;
    protected final CalendarManager calendar;

    public AddEvent(CalendarManager calendar, UserManager userManager) {
        this.calendar = calendar;
        this.userManager = userManager;
    }

    public LocalDateTime readDateTime() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Année (AAAA) : ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int hour = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());

        return LocalDateTime.of(year, month, day, hour, minute);
    }
}
