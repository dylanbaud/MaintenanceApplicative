import java.time.LocalDateTime;

public class Event {
    public Type type;
    public Title title;
    public Proprietaire proprietaire;
    public LocalDateTime dateDebut;
    public Duree duree;
    public String lieu; // utilisé seulement pour REUNION
    public String participants; // séparés par virgules (pour REUNION uniquement)
    public int frequenceJours; // uniquement pour PERIODIQUE

    public Event(Type type, Title title, Proprietaire proprietaire, LocalDateTime dateDebut, Duree duree,
                 String lieu, String participants, int frequenceJours) {
        this.type = type;
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.duree = duree;
        this.lieu = lieu;
        this.participants = participants;
        this.frequenceJours = frequenceJours;
    }

    public String description() {
        String desc = "";
        if (type.equals(Type.RDV_PERSONNEL)) {
            desc = "RDV : " + title + " à " + dateDebut.toString();
        } else if (type.equals(Type.REUNION)) {
            desc = "Réunion : " + title + " à " + lieu + " avec " + participants;
        } else if (type.equals(Type.PERIODIQUE)) {
            desc = "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
        }
        return desc;
    }
}