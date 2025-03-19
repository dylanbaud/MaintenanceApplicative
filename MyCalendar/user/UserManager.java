package user;

public class UserManager {
    private final Users users;

    public UserManager() {
        this.users = new Users();
        loadDefaultUsers();
    }

    public void loadDefaultUsers() {
        registerUser(new User(new Name("Roger"), new Password("Chat")));
        registerUser(new User(new Name("Pierre"), new Password("KiRouhl")));
    }

    public void registerUser(User user) {
        users.addUser(user);
    }

    public User authenticateUser(String name, String password) {
        for (User user : users.getUsers()) {
            if (user.getName().checkName(name) && user.getPassword().checkPassword(password)) {
                return user;
            }
        }
        return null;
    }
}