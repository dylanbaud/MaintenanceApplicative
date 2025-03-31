package fr.dylan.calendarapp.action;

import fr.dylan.calendarapp.display.*;
import fr.dylan.calendarapp.event.CalendarManager;
import fr.dylan.calendarapp.logged.*;
import fr.dylan.calendarapp.menu.*;
import fr.dylan.calendarapp.not_logged.CreateAccount;
import fr.dylan.calendarapp.not_logged.Login;
import fr.dylan.calendarapp.user.UserManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ActionManager {
    private final List<MenuAction> menus;
    private boolean running;
    private MenuType menuType;

    private final Scanner scanner = new Scanner(System.in);

    public ActionManager(UserManager userManager, CalendarManager calendar) {
        running = true;

        menus = new ArrayList<>();
        menuType = MenuType.NOT_LOGGED_MENU;

        MenuAction notLoggedMenu = new NotLoggedMenu(Arrays.asList(
                new Login(userManager, this),
                new CreateAccount(userManager, this)
        ));
        menus.add(notLoggedMenu);

        MenuAction loggedMenu = new LoggedMenu(new ArrayList<>(Arrays.asList(
                new DisplayEvents(this),
                new AddMeeting(calendar, userManager),
                new AddPeriodicEvent(calendar, userManager),
                new AddPersonalAppointment(calendar, userManager),
                new addConference(calendar, userManager),
                new Logout(this, userManager)
        )), userManager);
        menus.add(loggedMenu);

        MenuAction printMenu = new DisplayMenu(Arrays.asList(
                new DisplayAll(calendar),
                new DisplayByMonth(calendar),
                new DisplayByWeek(calendar),
                new DisplayByDay(calendar),
                new GoBackAction(this)
        ), this);
        menus.add(printMenu);
    }

    public void setMenuType(MenuType menuType) {
        this.menuType = menuType;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void askChoice() {
        MenuAction currentMenu = this.menus.get(menuType.ordinal());

        System.out.println(currentMenu);
        System.out.print("Choix : ");

        int choiceId = scanner.nextInt();
        currentMenu.executeAction(choiceId - 1);
    }
}