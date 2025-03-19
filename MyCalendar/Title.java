public class Title {

    private final String title;

    public Title(String title) {
        this.title = title;
    }

    public String toString() {
        return title;
    }

    public int hashCode() {
        return title.hashCode();
    }
}
