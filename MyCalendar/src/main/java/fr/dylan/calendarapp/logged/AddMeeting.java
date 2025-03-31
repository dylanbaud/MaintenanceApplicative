package fr.dylan.calendarapp.logged;

import fr.dylan.calendarapp.event.CalendarManager;
import fr.dylan.calendarapp.event.Duration;
import fr.dylan.calendarapp.event.Title;
import fr.dylan.calendarapp.event.meeting.Meeting;
import fr.dylan.calendarapp.event.meeting.Participant;
import fr.dylan.calendarapp.event.meeting.Participants;
import fr.dylan.calendarapp.event.meeting.Place;
import fr.dylan.calendarapp.user.UserManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AddMeeting extends AddEvent {
    public AddMeeting(CalendarManager calendar, UserManager userManager) {
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
        System.out.println("Lieu :");
        String location = scanner.nextLine();

        Participants participants = new Participants();
        participants.addParticipant(new Participant(userManager.getLoggedInUser().toString()));
        System.out.println("Ajouter un participant ? (O / N)");
        while (scanner.nextLine().equalsIgnoreCase("O")) {
            System.out.print("Nom du participant : ");
            Participant participant = new Participant(scanner.nextLine());
            participants.addParticipant(participant);
            System.out.println("Participants actuel: " + participants);
            System.out.println("Ajouter un participant ? (O / N)");
        }

        Meeting meeting = new Meeting(new Title(title), userManager.getLoggedInUser(), dateTime,
                new Duration(duration), new Place(location), participants);

        try {
            calendar.addEvent(meeting);
            System.out.println("Événement ajouté.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "Ajouter une réunion";
    }
}