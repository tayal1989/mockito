package learning.mockito.test_doubles.stub;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
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
}
