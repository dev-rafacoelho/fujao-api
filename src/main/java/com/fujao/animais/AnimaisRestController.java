package com.fujao.animais; 

import java.util.List;
import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/animais")
public class AnimaisRestController {

	@Autowired
	private AnimaisService animaisService;
	
    @GetMapping
    public List<Animais> buscarTodas() {
    	return animaisService.findAll();
    }
    
    @PostMapping
    public Animais salvarAnimais(@RequestBody Animais animal){
    	return animaisService.save(animal);
    }   
    

    @PutMapping("/{id}")
    public ResponseEntity<Animais> updateAnimais(@PathVariable Integer id, @RequestBody Animais animalDetalhes){
        
        Optional<Animais> animalExistente = animaisService.findById(id);

        if (!animalExistente.isPresent()) {
            return ResponseEntity.notFound().build(); // 
        }

        animalDetalhes.setId(id); 
        
        Animais animalAtualizado = animaisService.save(animalDetalhes);
        
        return ResponseEntity.ok(animalAtualizado);
    }
}