package fr.dylan.calendarapp.logged;

import fr.dylan.calendarapp.event.CalendarManager;
import fr.dylan.calendarapp.event.Duration;
import fr.dylan.calendarapp.event.PersonalAppointment;
import fr.dylan.calendarapp.event.Title;
import fr.dylan.calendarapp.user.UserManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AddPersonalAppointment extends AddEvent {
    public AddPersonalAppointment(CalendarManager calendar, UserManager userManager) {
        super(calendar, userManager);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Titre de l'événement : ");
        String title = scanner.nextLine();
        LocalDateTime dateTime = readDateTime();
        System.out.print("Durée (en minutes) : ");
        int duration = Integer.parseInt(scanner.nextLine());

        PersonalAppointment personalAppointment = new PersonalAppointment(new Title(title), userManager.getLoggedInUser(), dateTime, new Duration(duration));
        calendar.addEvent(personalAppointment);
        System.out.println("Événement ajouté.");
    }

    @Override
    public String getName() {
        return "Ajouter un rendez-vous personnel";
    }
}
