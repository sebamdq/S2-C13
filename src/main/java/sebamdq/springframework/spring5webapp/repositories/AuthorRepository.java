package sebamdq.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import sebamdq.springframework.spring5webapp.model.Author;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
