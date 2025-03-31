package fr.dylan.calendarapp.logged;

import fr.dylan.calendarapp.action.Action;
import fr.dylan.calendarapp.event.CalendarManager;

import java.util.Scanner;
import java.util.UUID;

public class DeleteEvent implements Action {
    private final CalendarManager calendar;

    public DeleteEvent(CalendarManager calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID de l'événement à supprimer : ");
        String id = scanner.nextLine();

        try {
            UUID eventId = UUID.fromString(id);
            calendar.removeEvent(eventId);
            System.out.println("Événement supprimé.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : ID invalide.");
        }
    }

    @Override
    public String getName() {
        return "Supprimer un événement";
    }
}