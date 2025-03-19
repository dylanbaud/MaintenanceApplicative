import java.util.Objects;

public class Utilisateur {

    private Prenom prenom;
    private MotDePasse motDePasse;

    public Utilisateur(Prenom prenom, MotDePasse motDePasse) {
        this.prenom = prenom;
        this.motDePasse = motDePasse;
    }

    public Prenom getPrenom() {
        return prenom;
    }

    public MotDePasse getMotDePasse() {
        return motDePasse;
    }

    public void setPrenom(Prenom prenom) {
        this.prenom = prenom;
    }

    public void setMotDePasse(MotDePasse motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenom, motDePasse);
    }
}
