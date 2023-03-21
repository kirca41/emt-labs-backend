package mk.ukim.finki.emtlabs.service;

import mk.ukim.finki.emtlabs.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> listAll();

    Optional<Author> create(String name, String surname, Long countryId);

    Optional<Author> update(Long id, String name, String surname, Long countryId);

    void deleteById(Long id);

    Optional<Author> findById(Long id);
}
