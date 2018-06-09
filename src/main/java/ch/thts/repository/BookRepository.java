package ch.thts.repository;

import ch.thts.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<BookEntity, Long> {

    List<BookEntity> findByTitle(String title);
}
