package fr.dylan.calendarapp.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {

    private UserManager userManager;

    @BeforeEach
    public void setUp() {
        userManager = new UserManager();
    }

    @Test
    public void testLoadDefaultUsers() {
        assertTrue(userManager.authenticateUser("Roger", "Chat"),
                "L'authentification devrait réussir avec l'utilisateur par défaut Roger");

        assertTrue(userManager.authenticateUser("Pierre", "KiRouhl"),
                "L'authentification devrait réussir avec l'utilisateur par défaut Pierre");
    }

    @Test
    public void testRegisterUser() {
        userManager.registerUser("Alice", "pwd123");

        assertNull(userManager.getLoggedInUser(),
                "L'utilisateur ne doit pas être connecté après l'enregistrement");

        assertTrue(userManager.authenticateUser("Alice", "pwd123"),
                "L'authentification devrait réussir avec l'utilisateur nouvellement enregistré");

        User loggedInUser = userManager.getLoggedInUser();
        assertNotNull(loggedInUser, "Un utilisateur doit être connecté après l'authentification");
        assertEquals("Alice", loggedInUser.getName().toString(),
                "Le nom de l'utilisateur connecté doit être Alice");
    }

    @Test
    public void testRegisterUserWithUserObject() {
        User newUser = new User(new Name("Bob"), new Password("secure"));
        userManager.registerUser(newUser);

        // Vérification que l'utilisateur n'est pas connecté automatiquement
        assertNull(userManager.getLoggedInUser(),
                "L'utilisateur ne doit pas être connecté après l'enregistrement");

        // Authentification requise après l'enregistrement
        assertTrue(userManager.authenticateUser("Bob", "secure"),
                "L'authentification devrait réussir avec l'utilisateur nouvellement enregistré");

        assertEquals("Bob", userManager.getLoggedInUser().getName().toString(),
                "Le nom de l'utilisateur connecté doit être Bob");
    }

    @Test
    public void testAuthentication() {
        userManager.registerUser("TestUser", "TestPass");

        assertTrue(userManager.authenticateUser("TestUser", "TestPass"),
                "L'authentification devrait réussir avec des identifiants valides");
        assertNotNull(userManager.getLoggedInUser(),
                "Un utilisateur doit être connecté après une authentification réussie");
        assertEquals("TestUser", userManager.getLoggedInUser().getName().toString(),
                "Le nom de l'utilisateur connecté doit être TestUser");
    }

    @Test
    public void testFailedAuthentication() {
        assertFalse(userManager.authenticateUser("Unknown", "WrongPass"),
                "L'authentification devrait échouer avec des identifiants invalides");
        assertNull(userManager.getLoggedInUser(),
                "Aucun utilisateur ne doit être connecté après une authentification échouée");
    }

    @Test
    public void testLogout() {
        userManager.authenticateUser("Roger", "Chat");
        assertNotNull(userManager.getLoggedInUser(),
                "Un utilisateur doit être connecté après une authentification réussie");

        userManager.logout();
        assertNull(userManager.getLoggedInUser(),
                "Aucun utilisateur ne doit être connecté après déconnexion");
    }
}