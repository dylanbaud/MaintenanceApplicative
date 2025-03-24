package action.not_logged;

import action.Action;
import action.ActionManager;
import menu.MenuType;
import user.UserManager;

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
