import user.Name;
import user.Password;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private final List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
        loadDefaultUsers();
    }

    public void loadDefaultUsers() {
        registerUser(new User(new Name("Roger"), new Password("Chat")));
        registerUser(new User(new Name("Pierre"), new Password("KiRouhl")));
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public User authenticateUser(String name, String password) {
        for (User user : users) {
            if (user.getName().checkName(name) && user.getPassword().checkPassword(password)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}