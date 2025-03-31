package fr.dylan.calendarapp.logged;

import fr.dylan.calendarapp.event.CalendarManager;
import fr.dylan.calendarapp.event.Duration;
import fr.dylan.calendarapp.event.PersonalAppointment;
import fr.dylan.calendarapp.event.Title;
import fr.dylan.calendarapp.event.conference.Conference;
import fr.dylan.calendarapp.event.conference.Speaker;
import fr.dylan.calendarapp.event.conference.Topic;
import fr.dylan.calendarapp.user.UserManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class addConference extends AddEvent {
    public addConference(CalendarManager calendar, UserManager userManager) {
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
        System.out.print("Sujet de la conférence : ");
        String description = scanner.nextLine();
        System.out.print("Nom du conférencier : ");
        String speaker = scanner.nextLine();
        Conference conference = new Conference(new Title(title), userManager.getLoggedInUser(), dateTime, new Duration(duration), new Topic(description), new Speaker(speaker));
        calendar.addEvent(conference);
        System.out.println("Événement ajouté.");
    }

    @Override
    public String getName() {
        return "Ajouter un conférence";
    }
}
