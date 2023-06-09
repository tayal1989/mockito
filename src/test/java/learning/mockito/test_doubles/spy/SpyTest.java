package learning.mockito.test_doubles.spy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpyTest {

    @Test
    public void testSpy() {
        BookRepositorySpy spyBookRepository = new BookRepositorySpy();
        BookService bookService = new BookService(spyBookRepository);

        Book book1 = new Book("1234", "Mockito In Action", 250.0, LocalDate.now());
        Book book2 = new Book("1235", "JUnit In Action", 200.0, LocalDate.now());

        bookService.addBook(book1);
        assertEquals(0, spyBookRepository.timesCalled());

        bookService.addBook(book2);
        assertEquals(1, spyBookRepository.timesCalled());
        assertTrue(spyBookRepository.calledWith(book2));
    }

    @Test
    public void testSpyWithMockito() {
        BookRepository bookRepository = Mockito.spy(BookRepository.class);
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
