package com.fujao.animais_encontrados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fotos")
public class FotosRestController {

    @Autowired
    private FotosService fotosService;

    @Autowired
    private AnimalEncontradoService animalEncontradoService;

    @GetMapping
    public List<Fotos> getAllFotos() {
        return fotosService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Fotos> getFotoById(@PathVariable Integer id) {
        Optional<Fotos> foto = fotosService.findById(id);
        return foto.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/animal/{animalId}")
    public ResponseEntity<List<Fotos>> getFotosByAnimalId(@PathVariable Integer animalId) {
        Optional<AnimalEncontrado> animal = animalEncontradoService.findById(animalId);
        if (!animal.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        List<Fotos> fotosDoAnimal = fotosService.findByAnimal(animal.get());
        return ResponseEntity.ok(fotosDoAnimal);
    }

    @PostMapping(value = "/{animalId}", consumes = "text/plain") // <-- MUDANÇA AQUI
    public ResponseEntity<Fotos> createFoto(@PathVariable Integer animalId, @RequestBody String base64Image) {
        Optional<AnimalEncontrado> animalEncontradoOpt = animalEncontradoService.findById(animalId);
        if (!animalEncontradoOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Fotos novaFoto = new Fotos();
        novaFoto.setAnimal(animalEncontradoOpt.get());
        novaFoto.setBase64(base64Image);
        
        Fotos fotoSalva = fotosService.save(novaFoto);
        return new ResponseEntity<>(fotoSalva, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoto(@PathVariable Integer id) {
        if (!fotosService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        fotosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}