package dev.mateuslh.controller;

import dev.mateuslh.model.Cidade;
import dev.mateuslh.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ResponseEntity<Page<Cidade>> getPaginated(Pageable pageable) {
        return ResponseEntity.ok(cidadeService.findAll(pageable));
    }

    @GetMapping("/nonpaged")
    public ResponseEntity<List<Cidade>> getAll() {
        return ResponseEntity.ok(cidadeService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cidade> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cidadeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Cidade> create(@RequestBody Cidade cidade) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cidadeService.save(cidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cidadeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> update(@PathVariable Long id, @RequestBody Cidade cidade) {
        Cidade cidadeAtualizada = cidadeService.update(id, cidade);
        return ResponseEntity.ok(cidadeAtualizada);
    }
}
