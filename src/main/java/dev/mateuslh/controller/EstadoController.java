package dev.mateuslh.controller;

import dev.mateuslh.model.Estado;
import dev.mateuslh.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<Page<Estado>> get(Pageable pageable) {
        return ResponseEntity.ok(estadoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> getById(@PathVariable Long id) {
        return ResponseEntity.ok(estadoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Estado> create(@RequestBody Estado estado) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(estadoService.save(estado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCidade(@PathVariable Long id) {
        estadoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> updateCidade(@PathVariable Long id, @RequestBody Estado estado) {
        Estado estadoAtualizado = estadoService.update(id, estado);
        return ResponseEntity.ok(estadoAtualizado);
    }
}
