package learning.mockito.test_doubles.annotations.support;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);
}
