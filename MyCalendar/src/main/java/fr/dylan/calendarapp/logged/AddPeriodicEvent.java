package fr.dylan.calendarapp.logged;

import fr.dylan.calendarapp.event.CalendarManager;
import fr.dylan.calendarapp.event.Duration;
import fr.dylan.calendarapp.event.Title;
import fr.dylan.calendarapp.event.periodic.Frequency;
import fr.dylan.calendarapp.event.periodic.PeriodicEvent;
import fr.dylan.calendarapp.user.UserManager;

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

        try {
            calendar.addEvent(periodicEvent);
            System.out.println("Événement ajouté.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "Ajouter un évènement périodique";
    }
}