package learning.mockito.test_doubles.stub;

import java.time.LocalDate;
import java.util.*;

public class StubBookRepository implements BookRepository {

    // In memory database, HashMap or List
    Map<String, Book> mapBookStore = new HashMap<>();

    @Override
    public List<Book> findNewBooks(int days) {
        List<Book> newBooks = new ArrayList<>();
        Book book1 = new Book("1234", "Mockito In Action", 500.0, LocalDate.now());
        Book book2 = new Book("1235", "JUnit In Action", 400.0, LocalDate.now());
        newBooks.add(book1);
        newBooks.add(book2);
        return newBooks;
    }
}
