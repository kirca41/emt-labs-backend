package mk.ukim.finki.emtlabs.service;

import mk.ukim.finki.emtlabs.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> listAll();

    Optional<Country> create(String name, String continent);

    Optional<Country> update(Long id, String name, String continent);

    void deleteById(Long id);

    Optional<Country> findById(Long id);
}
