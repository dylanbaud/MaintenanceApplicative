public class Proprietaire {

    private final String proprietaire;

    public Proprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String toString() {
        return proprietaire;
    }

    public int hashCode() {
        return proprietaire.hashCode();
    }
}
