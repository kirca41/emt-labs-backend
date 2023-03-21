package mk.ukim.finki.emtlabs.web.rest;

import mk.ukim.finki.emtlabs.model.Country;
import mk.ukim.finki.emtlabs.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> listAll() {
        return this.countryService.listAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Country> create(String name, String continent) {
        return this.countryService.create(name, continent)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Country> update(@PathVariable Long id, String name, String continent) {
        return this.countryService.update(id, name, continent)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.countryService.deleteById(id);
        if (this.countryService.findById(id).isEmpty())
            return ResponseEntity.ok().build();

        return ResponseEntity.badRequest().build();
    }

}
