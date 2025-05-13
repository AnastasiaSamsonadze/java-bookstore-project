package book;

public class TheWitcher extends Book{
    private final String subtitle;

    public TheWitcher(Genre genre, int numberOfPages, int price, int ageLimit, String subtitle) {
        super(genre, numberOfPages, price, ageLimit);
        this.subtitle = subtitle;
    }

    @Override
    public String toString() {
        return super.toString() + ", Subtitle: " + subtitle;
    }

}
