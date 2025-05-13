package book;

public class Book {
    private final Genre genre;
    private final int numberOfPages;
    private final int price;
    private final int ageLimit;

    public Book(Genre genre, int numberOfPages, int price, int ageLimit) {
        this.genre = genre;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.ageLimit = ageLimit;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getPrice() {
        return price;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    @Override
    public String toString() {
        return "Genre of the book: " + genre + ", Price: " + price + ", Number of pages:" + numberOfPages + ", Cannot be purchased under " + ageLimit;
    }
    
}
