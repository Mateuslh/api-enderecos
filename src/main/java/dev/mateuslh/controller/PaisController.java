package dev.mateuslh.controller;

import dev.mateuslh.model.Pais;
import dev.mateuslh.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pais")
public class PaisController {
    @Autowired
    private PaisService paisService;

    @GetMapping("/nonpaged")
    public ResponseEntity<List<Pais>> getAll() {
        return ResponseEntity.ok(paisService.findAll());
    }

    @GetMapping
    public ResponseEntity<Page<Pais>> getPaginated(Pageable pageable) {
        return ResponseEntity.ok(paisService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> getById(@PathVariable Long id) {
        return ResponseEntity.ok(paisService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Pais> create(@RequestBody Pais pais) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(paisService.save(pais));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paisService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pais> update(@PathVariable Long id, @RequestBody Pais pais) {
        Pais paisAtualizado = paisService.update(id, pais);
        return ResponseEntity.ok(paisAtualizado);
    }
}
