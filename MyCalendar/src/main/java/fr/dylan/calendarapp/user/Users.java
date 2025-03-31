package fr.dylan.calendarapp.user;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private List<User> users;

    public Users() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public User getUser(String firstName) {
        for (User user : users) {
            if (user.getName().checkName(firstName)) {
                return user;
            }
        }
        return null;
    }
}
