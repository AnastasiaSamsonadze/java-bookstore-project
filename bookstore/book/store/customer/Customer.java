package book.store.customer;

import java.util.Set;

import book.Book;
import book.store.BookStore;

public class Customer {
    private final int age;
    private int balance;
    private BookStore location;
    private Set<Book> basket = Set.of();

    public Customer(int age, int balance) {
        this.age = age;
        this.balance = balance;
    }

    private boolean canPurchase(Book book) {
        if (book.getAgeLimit() > this.age) {
            return false;
        }
        return true;
    }

    public void checkout() {
        int sum = summarizeBasket();
        if (sum > balance) {
            try {
                throw new InsufficientBalanceException();
            } catch (InsufficientBalanceException e) {
                e.printStackTrace();
            }
        }
        for (Book b : basket) {
            if (!canPurchase(b)) {
                basket.remove(b);
            }
        }
        this.balance -= sum;

        System.out.println(String.format("Total: %d Balance after payment: %d", sum, balance));
        
    }

    public void enter(BookStore store) {
        this.location = store;
    }

    public void putIntoBasket(Book book) {
        if (canPurchase(book)) {
            basket.add(book);
        }
    }

    public int summarizeBasket() {
        int sum = 0;
        for (Book b : basket) {
            sum += b.getPrice();
        }
        return sum;
    }
}
