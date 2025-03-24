package action.logged;

import event.CalendarManager;
import event.Duration;
import event.PersonalAppointment;
import event.Title;
import event.periodic.Frequency;
import event.periodic.PeriodicEvent;
import user.UserManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AddPeriodicEvent extends AddEvent {
    public AddPeriodicEvent(CalendarManager calendar, UserManager userManager) {
        super(calendar, userManager);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Titre de l'événement : ");
        String title = scanner.nextLine();
        LocalDateTime dateTime = readDateTime();
        System.out.print("Frequence (en jours) : ");
        int frequency = Integer.parseInt(scanner.nextLine());

        PeriodicEvent periodicEvent = new PeriodicEvent(new Title(title), userManager.getLoggedInUser(), dateTime,
                new Duration(0), new Frequency(frequency));
        calendar.addEvent(periodicEvent);
        System.out.println("Événement ajouté.");
    }

    @Override
    public String getName() {
        return "Ajouter un évènement périodique";
    }
}
