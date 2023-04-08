package learning.mockito.test_doubles.mock;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MockTest {

    @Test
    public void testMock() {
        BookRepositoryMock mockBookRepository = new BookRepositoryMock();
        BookService bookService = new BookService(mockBookRepository);

        Book book1 = new Book("1234", "Mockito In Action", 250.0, LocalDate.now());
        Book book2 = new Book("1235", "JUnit In Action", 200.0, LocalDate.now());

        bookService.addBook(book1);
        mockBookRepository.verify(null, 0); // See BookService.java, it don't saves book having book price > 200

        bookService.addBook(book2);
        mockBookRepository.verify(book2, 1);
    }
}
