package fr.dylan.calendarapp.user;

import java.util.Objects;

public class User {

    private Name name;
    private Password password;

    public User(Name name, Password password) {
        this.name = name;
        this.password = password;
    }

    public Name getName() {
        return name;
    }

    public Password getPassword() {
        return password;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
}
