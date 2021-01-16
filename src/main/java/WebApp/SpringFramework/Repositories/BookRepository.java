package WebApp.SpringFramework.Repositories;

import WebApp.SpringFramework.Domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
