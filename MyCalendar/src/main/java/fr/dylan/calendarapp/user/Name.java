package fr.dylan.calendarapp.user;

import java.util.Objects;

public class Name {

    private final String firstName;

    public Name(String firstName) {
        this.firstName = firstName;
    }

    public String toString() {
        return firstName;
    }

    public boolean checkName(String firstName) {
        return this.firstName.equals(firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(firstName);
    }
}
