package fr.dylan.calendarapp.display;

import fr.dylan.calendarapp.action.Action;
import fr.dylan.calendarapp.action.ActionManager;
import fr.dylan.calendarapp.menu.MenuType;
import fr.dylan.calendarapp.user.UserManager;

import java.util.Scanner;

public class Logout implements Action {
    private final ActionManager actionManager;
    private final UserManager userManager;

    public Logout(ActionManager actionManager, UserManager userManager) {
        this.actionManager = actionManager;
        this.userManager = userManager;
    }


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Déconnexion ! Voulez-vous continuer ? (oui/non)");
        userManager.logout();
        actionManager.setMenuType(MenuType.NOT_LOGGED_MENU);
        actionManager.setRunning(scanner.nextLine().trim().equalsIgnoreCase("oui"));
    }

    @Override
    public String getName() {
        return "Se déconnecter";
    }
}
