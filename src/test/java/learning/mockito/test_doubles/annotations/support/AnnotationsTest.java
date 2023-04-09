package learning.mockito.test_doubles.annotations.support;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AnnotationsTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testCreateMocksUsingAnnotations() {
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
