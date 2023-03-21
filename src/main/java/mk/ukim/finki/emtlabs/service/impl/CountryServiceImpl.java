package mk.ukim.finki.emtlabs.service.impl;

import mk.ukim.finki.emtlabs.model.Country;
import mk.ukim.finki.emtlabs.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.emtlabs.repository.CountryRepository;
import mk.ukim.finki.emtlabs.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> create(String name, String continent) {
        return Optional.of(this.countryRepository.save(new Country(name, continent)));
    }

    @Override
    public Optional<Country> update(Long id, String name, String continent) {
        Country country = this.countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id.toString()));
        country.setName(name);
        country.setContinent(continent);
        return Optional.of(this.countryRepository.save(country));
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }
}
