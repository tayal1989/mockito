package learning.mockito.test_doubles.stub;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StubTest {

    @Test
    public void testStub() {
        BookRepository bookRepository = new StubBookRepository();
        BookService bookService = new BookService(bookRepository);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10.0f, 7);
        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450.0, newBooksWithAppliedDiscount.get(0).getBookPrice());
        assertEquals(360.0, newBooksWithAppliedDiscount.get(1).getBookPrice());
    }

    @Test
    public void testStubWithMockito() {
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1234", "Mockito In Action", 500.0, LocalDate.now());
        Book book2 = new Book("1235", "JUnit In Action", 400.0, LocalDate.now());

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        Mockito.when(bookRepository.findNewBooks(7)).thenReturn(books);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10.0f, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450.0, newBooksWithAppliedDiscount.get(0).getBookPrice());
        assertEquals(360.0, newBooksWithAppliedDiscount.get(1).getBookPrice());
    }
}
