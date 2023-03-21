package mk.ukim.finki.emtlabs.web.rest;

import mk.ukim.finki.emtlabs.model.Author;
import mk.ukim.finki.emtlabs.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> listAll() {
        return this.authorService.listAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Author> create(String name, String surname, Long countryId) {
        return this.authorService.create(name, surname, countryId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Author> update(@PathVariable Long id, String name, String surname, Long countryId) {
        return this.authorService.update(id, name, surname, countryId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.authorService.deleteById(id);
        if (this.authorService.findById(id).isEmpty())
            return ResponseEntity.ok().build();

        return ResponseEntity.badRequest().build();
    }
}
