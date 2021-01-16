package WebApp.SpringFramework.Repositories;

import WebApp.SpringFramework.Domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
