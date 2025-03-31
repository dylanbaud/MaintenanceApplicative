package fr.dylan.calendarapp.menu;

import fr.dylan.calendarapp.action.Action;
import fr.dylan.calendarapp.user.UserManager;

import java.util.List;

public class LoggedMenu extends MenuAction {
    private final UserManager userManager;

    public LoggedMenu(List<Action> actions, UserManager userManager) {
        super(actions);
        this.userManager = userManager;
    }

    @Override
    public String getIntro() {
        return "\nBonjour, %s\n=== Menu Gestionnaire d'Événements ===\n".formatted(userManager.getLoggedInUser());
    }
}
