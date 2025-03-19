import java.util.Objects;

public class MotDePasse {

    private String motDePasse;

    public MotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean checkMotDePasse(String motDePasse) {
        return this.motDePasse.equals(motDePasse);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(motDePasse);
    }
}
