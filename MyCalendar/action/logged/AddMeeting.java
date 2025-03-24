package action.logged;

import event.CalendarManager;
import event.Duration;
import event.PersonalAppointment;
import event.Title;
import event.meeting.Meeting;
import event.meeting.Participant;
import event.meeting.Participants;
import event.meeting.Place;
import user.UserManager;

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
        calendar.addEvent(meeting);
        System.out.println("Événement ajouté.");
    }

    @Override
    public String getName() {
        return "Ajouter une réunion";
    }
}
