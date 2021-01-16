package WebApp.SpringFramework.Repositories;

import WebApp.SpringFramework.Domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long>{
}
