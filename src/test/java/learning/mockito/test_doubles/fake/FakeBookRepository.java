package learning.mockito.test_doubles.fake;

import learning.mockito.test_doubles.fake.Book;
import learning.mockito.test_doubles.fake.BookRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository {

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
