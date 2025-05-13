package book.store;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import book.Book;
import book.Genre;


public class BookStore {
    public ArrayList<Book> shelf = new ArrayList<Book>();

    public BookStore(String filename) throws FileNotFoundException, UnknownGenreException {
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] bookData = data.split(":");
            String genre = bookData[1]; 
            if (!isKnownGenre(genre)) {
                throw new UnknownGenreException("This kind of book cannot be sold.");
            }
            shelf.add(new Book(Genre.valueOf(genre), Integer.parseInt(bookData[2]), Integer.parseInt(bookData[3]), Integer.parseInt(bookData[3]))); 
        }
        myReader.close();
    }

    private boolean isKnownGenre(String genre) {
        for (Genre g : Genre.values()) {
            if (g.name().equals(genre)) {
                return true;
            }
        }
        return false;
    }

    public void purchased(Book book) {
        for (Book b : shelf) {
            if (b.toString().equals(book.toString())) {
                shelf.remove(b);
            }
        }
    }

    public void shipmentArrived(ArrayList<Book> books) {
        for (Book b : books) {
            shelf.add(b);
        }
    }
}
