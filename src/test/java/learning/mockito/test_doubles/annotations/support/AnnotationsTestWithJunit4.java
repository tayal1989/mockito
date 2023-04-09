package learning.mockito.test_doubles.annotations.support;

import org.assertj.core.api.BDDAssertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(MockitoJUnitRunner.class)
public class AnnotationsTestWithJunit4 {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Before
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

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

    @Test
    @DisplayName("Given - new books, When - Discount is applied, Then - New Books with applied discount will be returned")
    public void test_Given_NewBooks_When_GetNewBooksWithAppliedDiscountIsCalled_NewBooksWithAppliedDiscountIsReturned() {
        Book book1 = new Book("1234", "Mockito In Action", 500.0, LocalDate.now());
        Book book2 = new Book("1235", "JUnit In Action", 400.0, LocalDate.now());

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        BDDMockito.given(bookRepository.findNewBooks(7)).willReturn(books);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10.0f, 7);

        BDDAssertions.then(newBooksWithAppliedDiscount).isNotNull();
        BDDAssertions.then(newBooksWithAppliedDiscount.size()).isEqualTo(2);
        BDDAssertions.then(newBooksWithAppliedDiscount.get(0).getBookPrice()).isEqualTo(450.0);
        BDDAssertions.then(newBooksWithAppliedDiscount.get(1).getBookPrice()).isEqualTo(360.0);
    }
}
