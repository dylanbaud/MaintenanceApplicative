package fr.dylan.calendarapp.user;

import java.util.Objects;

public class Password {

    private String password;

    public Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(String motDePasse) {
        return this.password.equals(motDePasse);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(password);
    }
}
