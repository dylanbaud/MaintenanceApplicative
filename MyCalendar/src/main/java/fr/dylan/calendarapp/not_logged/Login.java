package fr.dylan.calendarapp.not_logged;

import fr.dylan.calendarapp.action.Action;
import fr.dylan.calendarapp.action.ActionManager;
import fr.dylan.calendarapp.menu.MenuType;
import fr.dylan.calendarapp.user.UserManager;

import java.awt.event.ActionListener;
import java.util.Scanner;

public class Login implements Action {
    private final UserManager userManager;
    private final ActionManager actionManager;

    public Login(UserManager userManager, ActionManager actionManager) {
        this.userManager = userManager;
        this.actionManager = actionManager;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nom d'utilisateur: ");
        String firstName = scanner.nextLine();

        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();

        boolean logged = userManager.authenticateUser(firstName, password);

        if (logged) {
            actionManager.setMenuType(MenuType.LOGGED_MENU);
        } else {
            System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
        }
    }

    @Override
    public String getName() {
        return "Se connecter";
    }
}
