package learning.mockito.test_doubles.dummy;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyTest {

    @Test
    public void testDummy() {
        BookRepository bookRepository = new DummyBookRepository();
        EmailService emailService = new DummyEmailService();
        BookService bookService = new BookService(bookRepository, emailService);

        bookService.addBook(new Book("1234", "Mockito In Action", 250.0, LocalDate.now()));
        bookService.addBook(new Book("1235", "JUnit In Action", 200.0, LocalDate.now()));

        assertEquals(2, bookService.findNumberOfBooks());
    }
}
