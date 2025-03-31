package fr.dylan.calendarapp;

import fr.dylan.calendarapp.action.ActionManager;
import fr.dylan.calendarapp.event.CalendarManager;
import fr.dylan.calendarapp.user.UserManager;

public class CalendarApp {
    public static void main(String[] args) {
        CalendarManager calendar = new CalendarManager();

        UserManager userManager = new UserManager();

        ActionManager actionManager = new ActionManager(userManager, calendar);

        while (actionManager.isRunning()) {
            actionManager.askChoice();
        }
    }
}