package mk.ukim.finki.emtlabs.repository;

import mk.ukim.finki.emtlabs.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
