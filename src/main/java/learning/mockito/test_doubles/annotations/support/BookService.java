package learning.mockito.test_doubles.annotations.support;

import java.util.List;

public class BookService {
    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getNewBooksWithAppliedDiscount(float discountRate, int days) {
        List<Book> newBooks = bookRepository.findNewBooks(days);

        for(Book book : newBooks) {
            double price = book.getBookPrice();
            double newPrice = price - (discountRate * price / 100);
            book.setBookPrice(newPrice);
        }

        return newBooks;
    }
}
