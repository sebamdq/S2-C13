package sebamdq.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import sebamdq.springframework.spring5webapp.model.Book;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

}
