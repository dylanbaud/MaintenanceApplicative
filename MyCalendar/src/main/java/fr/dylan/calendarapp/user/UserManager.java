package fr.dylan.calendarapp.user;

public class UserManager {
    private final Users users;
    private User user;

    public UserManager() {
        this.users = new Users();
        this.user = null;
        loadDefaultUsers();
    }

    public void loadDefaultUsers() {
        registerUser(new User(new Name("Roger"), new Password("Chat")));
        registerUser(new User(new Name("Pierre"), new Password("KiRouhl")));
    }

    public void registerUser(String name, String password) {
        registerUser(new User(new Name(name), new Password(password)));
    }

    public void registerUser(User user) {
        users.addUser(user);
        this.user = user;
    }

    public boolean authenticateUser(String name, String password) {
        for (User u : users.getUsers()) {
            if (u.getName().checkName(name) && u.getPassword().checkPassword(password)) {
                user = u;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        user = null;
    }

    public User getLoggedInUser() {
        return user;
    }
}