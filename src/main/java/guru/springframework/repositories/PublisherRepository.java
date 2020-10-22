package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import guru.springframework.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
