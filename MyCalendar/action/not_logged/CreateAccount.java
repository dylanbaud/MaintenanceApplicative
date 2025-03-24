package action.not_logged;

import action.Action;
import action.ActionManager;
import menu.MenuType;
import user.UserManager;

import java.util.Scanner;

public class CreateAccount implements Action {
    private final UserManager userManager;
    private final ActionManager actionManager;

    public CreateAccount(UserManager userManager, ActionManager actionManager) {
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
        System.out.print("Répéter mot de passe: ");
        if (scanner.nextLine().equals(password)) {
            userManager.registerUser(firstName, password);
            actionManager.setMenuType(MenuType.LOGGED_MENU);
        } else {
            System.out.println("Les mots de passes ne correspondent pas...");
        }
    }

    @Override
    public String getName() {
        return "Créer un compte";
    }
}
