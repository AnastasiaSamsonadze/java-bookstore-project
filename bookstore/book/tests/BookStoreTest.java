package book.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import book.Book;
import book.Genre;
import book.TheWitcher;
import book.store.BookStore;
import book.store.UnknownGenreException;

public class BookStoreTest {

    @Test
    public void shelf() {
        try {
            BookStore bookStore = new BookStore("exampleFile.txt");
            bookStore.purchased(new Book(Genre.FANTASY, 432, 3990, 18));
            assertEquals(0, bookStore.shelf.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnknownGenreException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shelfWithBook() {
        try {
            Book theWitcher = new TheWitcher(Genre.FANTASY, 432, 3990, 18, "Blood of elves");
            ArrayList<Book> books = new ArrayList<Book>();
            books.add(theWitcher);
            BookStore bookStore;
            bookStore = new BookStore("testWitcher.txt");
            bookStore.shipmentArrived(books);
            assertEquals(theWitcher, bookStore.shelf.get(0));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnknownGenreException e) {
            e.printStackTrace();
        }

    }
}
