import java.util.Objects;

public class Prenom {

    private final String prenom;

    public Prenom(String prenom) {
        this.prenom = prenom;
    }

    public String toString() {
        return prenom;
    }

    public boolean checkPrenom(String prenom) {
        return this.prenom.equals(prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(prenom);
    }
}
