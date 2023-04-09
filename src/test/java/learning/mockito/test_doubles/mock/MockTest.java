package learning.mockito.test_doubles.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

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

    @Test
    public void testMockWithMockito() {
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1234", "Mockito In Action", 250.0, LocalDate.now());
        Book book2 = new Book("1235", "JUnit In Action", 200.0, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        Mockito.verify(bookRepository).save(book2);
        Mockito.verify(bookRepository, Mockito.times(1)).save(book2);
        Mockito.verify(bookRepository, Mockito.times(0)).save(book1);
    }
}
