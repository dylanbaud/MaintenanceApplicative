import user.Name;
import user.Password;
import user.User;

import java.util.Scanner;

public class HomeManager {
    private final UserManager userManager;
    private final Scanner scanner;
    private User currentUser;

    public HomeManager(UserManager userManager) {
        this.userManager = userManager;
        this.scanner = new Scanner(System.in);
        this.currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void handleHomeMenu() {
        DisplayManager.showLoginHeader();
        System.out.println("1 - Se connecter");
        System.out.println("2 - Créer un compte");
        System.out.println("Choix : ");

        switch (scanner.nextLine()) {
            case "1":
                handleLogin();
                break;
            case "2":
                handleCreateAccount();
                break;
        }
    }

    public void handleLogin() {
        System.out.print("Nom d'utilisateur: ");
        String firstName = scanner.nextLine();

        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();

        User user = userManager.authenticateUser(firstName, password);
        if (user != null) {
            currentUser = user;
        } else {
            System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
        }
    }

    public void handleCreateAccount() {
        System.out.print("Nom d'utilisateur: ");
        String firstName = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();
        System.out.print("Répéter mot de passe: ");
        if (scanner.nextLine().equals(password)) {
            User u = new User(new Name(firstName), new Password(password));
            userManager.registerUser(u);
        } else {
            System.out.println("Les mots de passes ne correspondent pas...");
        }
    }

    public boolean isUserConnected() {
        return currentUser != null;
    }

    public void logout() {
        System.out.println("Déconnexion ! Voulez-vous continuer ? (O/N)");
        if (scanner.nextLine().equalsIgnoreCase("o")) {
            currentUser = null;
        }
    }
}