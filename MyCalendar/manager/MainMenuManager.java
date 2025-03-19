package manager;

import event.*;
import event.meeting.Meeting;
import event.meeting.Participant;
import event.meeting.Participants;
import event.meeting.Place;
import event.periodic.Frequence;
import event.periodic.PeriodicEvent;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MainMenuManager {
    private final EventManager calendar;
    private final HomeManager homeManager;
    private final Scanner scanner;

    public MainMenuManager(EventManager calendar, HomeManager homeManager) {
        this.calendar = calendar;
        this.homeManager = homeManager;
        this.scanner = new Scanner(System.in);
    }

    public void handleMainMenu() {
        System.out.println("\nBonjour, " + homeManager.getCurrentUser().getName());
        System.out.println("=== Menu Gestionnaire d'Événements ===");
        System.out.println("1 - Voir les événements");
        System.out.println("2 - Ajouter un rendez-vous perso");
        System.out.println("3 - Ajouter une réunion");
        System.out.println("4 - Ajouter un évènement périodique");
        System.out.println("5 - Se déconnecter");
        System.out.print("Votre choix : ");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                handleViewEventsMenu();
                break;
            case "2":
                handleAddPersonalAppointment();
                break;
            case "3":
                handleAddMeeting();
                break;
            case "4":
                handleAddPeriodicEvent();
                break;
            default:
                homeManager.logout();
                break;
        }
    }

    private void handleViewEventsMenu() {
        System.out.println("\n=== Menu de visualisation d'Événements ===");
        System.out.println("1 - Afficher TOUS les événements");
        System.out.println("2 - Afficher les événements d'un MOIS précis");
        System.out.println("3 - Afficher les événements d'une SEMAINE précise");
        System.out.println("4 - Afficher les événements d'un JOUR précis");
        System.out.println("5 - Retour");
        System.out.print("Votre choix : ");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                calendar.afficherEvenements();
                break;
            case "2":
                displayEventsByMonth();
                break;
            case "3":
                displayEventsByWeek();
                break;
            case "4":
                displayEventsByDay();
                break;
        }
    }

    private void displayEventsByMonth() {
        System.out.print("Entrez l'année (AAAA) : ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int month = Integer.parseInt(scanner.nextLine());

        LocalDateTime startMonth = LocalDateTime.of(year, month, 1, 0, 0);
        LocalDateTime endMonth = startMonth.plusMonths(1).minusSeconds(1);

        displayEventsList(calendar.eventsDansPeriode(startMonth, endMonth));
    }

    private void displayEventsByWeek() {
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

        displayEventsList(calendar.eventsDansPeriode(startWeek, endWeek));
    }

    private void displayEventsByDay() {
        System.out.print("Entrez l'année (AAAA) : ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le jour (1-31) : ");
        int day = Integer.parseInt(scanner.nextLine());

        LocalDateTime startDay = LocalDateTime.of(year, month, day, 0, 0);
        LocalDateTime endDay = startDay.plusDays(1).minusSeconds(1);

        displayEventsList(calendar.eventsDansPeriode(startDay, endDay));
    }

    private void displayEventsList(List<Event> events) {
        if (events.isEmpty()) {
            System.out.println("Aucun événement trouvé pour cette période.");
        } else {
            System.out.println("Événements trouvés : ");
            for (Event e : events) {
                System.out.println("- " + e.description());
            }
        }
    }

    private void handleAddPersonalAppointment() {
        System.out.print("Titre de l'événement : ");
        String title = scanner.nextLine();
        LocalDateTime dateTime = readDateTime();
        System.out.print("Durée (en minutes) : ");
        int duration = Integer.parseInt(scanner.nextLine());

        PersonalAppointment personalAppointment = new PersonalAppointment(new Title(title), homeManager.getCurrentUser(), dateTime, new Duration(duration));
        calendar.ajouterEvent(personalAppointment);
        System.out.println("Événement ajouté.");
    }

    private void handleAddMeeting() {
        System.out.print("Titre de l'événement : ");
        String title = scanner.nextLine();
        LocalDateTime dateTime = readDateTime();
        System.out.print("Durée (en minutes) : ");
        int duration = Integer.parseInt(scanner.nextLine());
        System.out.println("Lieu :");
        String location = scanner.nextLine();

        Participants participants = new Participants();
        participants.addParticipant(new Participant(homeManager.getCurrentUser().getName().toString()));
        System.out.println("Ajouter un participant ? (O / N)");
        while (scanner.nextLine().equalsIgnoreCase("O")) {
            System.out.print("Nom du participant : ");
            Participant participant = new Participant(scanner.nextLine());
            participants.addParticipant(participant);
            System.out.println("Participants actuel: " + participants);
            System.out.println("Ajouter un participant ? (O / N)");
        }

        Meeting meeting = new Meeting(new Title(title), homeManager.getCurrentUser(), dateTime,
                new Duration(duration), new Place(location), participants);
        calendar.ajouterEvent(meeting);
        System.out.println("Événement ajouté.");
    }

    private void handleAddPeriodicEvent() {
        System.out.print("Titre de l'événement : ");
        String title = scanner.nextLine();
        LocalDateTime dateTime = readDateTime();
        System.out.print("Frequence (en jours) : ");
        int frequency = Integer.parseInt(scanner.nextLine());

        PeriodicEvent periodicEvent = new PeriodicEvent(new Title(title), homeManager.getCurrentUser(), dateTime,
                new Duration(0), new Frequence(frequency));
        calendar.ajouterEvent(periodicEvent);
        System.out.println("Événement ajouté.");
    }

    private LocalDateTime readDateTime() {
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