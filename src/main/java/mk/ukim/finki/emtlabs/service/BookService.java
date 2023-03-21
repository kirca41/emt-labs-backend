package mk.ukim.finki.emtlabs.service;

import mk.ukim.finki.emtlabs.model.Book;
import mk.ukim.finki.emtlabs.model.dto.BookDto;
import mk.ukim.finki.emtlabs.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> listAll();

    Optional<Book> create(String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> create(BookDto bookDto);

    Optional<Book> update(Long id, String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> update(Long id, BookDto bookDto);

    void deleteById(Long id);

    Optional<Book> markAsTaken(Long id);

    Optional<Book> findById(Long id);
}
