package trivia;

public enum Category {
    POP("Pop"), SCIENCE("Science"), SPORTS("Sports"), ROCK("Rock");

    private final String stringValue;

    Category(final String s){
        this.stringValue = s;
    }

    public String toString(){
        return this.stringValue;
    }
}
