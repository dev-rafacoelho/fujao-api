package com.fujao.animais_encontrados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animais_encontrados")
public class AnimalEncontradoRestController {

    @Autowired
    private AnimalEncontradoService animalEncontradoService;

    @GetMapping
    public List<AnimalEncontrado> getAllAnimaisEncontrados() {
        return animalEncontradoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalEncontrado> getAnimalEncontradoById(@PathVariable Integer id) {
        Optional<AnimalEncontrado> animal = animalEncontradoService.findById(id);
        return animal.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AnimalEncontrado> createAnimalEncontrado(@RequestBody AnimalEncontrado animalEncontrado) {
        AnimalEncontrado novoAnimal = animalEncontradoService.save(animalEncontrado);
        return new ResponseEntity<>(novoAnimal, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalEncontrado> updateAnimalEncontrado(@PathVariable Integer id, @RequestBody AnimalEncontrado animalEncontrado) {
        if (!animalEncontradoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        animalEncontrado.setId(id);
        AnimalEncontrado animalAtualizado = animalEncontradoService.save(animalEncontrado);
        return ResponseEntity.ok(animalAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimalEncontrado(@PathVariable Integer id) {
        if (!animalEncontradoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        animalEncontradoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}