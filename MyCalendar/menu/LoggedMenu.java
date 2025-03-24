package menu;

import action.Action;
import user.UserManager;

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
