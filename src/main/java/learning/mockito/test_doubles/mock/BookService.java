package learning.mockito.test_doubles.mock;

public class BookService {
    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void addBook(Book book) {
        if(book.getBookPrice() > 200) {
            return;
        }
        bookRepository.save(book);
    }
}
