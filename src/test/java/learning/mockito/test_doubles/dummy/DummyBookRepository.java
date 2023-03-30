package learning.mockito.test_doubles.dummy;

import learning.mockito.test_doubles.dummy.Book;
import learning.mockito.test_doubles.dummy.BookRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DummyBookRepository implements BookRepository {

    // In memory database, HashMap or List
    Map<String, Book> mapBookStore = new HashMap<>();
    @Override
    public void save(Book book) {
        mapBookStore.put(book.getBookId(), book);
    }

    @Override
    public Collection<Book> findAll() {
        return mapBookStore.values();
    }
}
