package com.fujao.animais_encontrados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FotosService {

    @Autowired
    private FotosRepository fotosRepository;
    
    public List<Fotos> findAll() {
        return fotosRepository.findAll();
    }
    
    public Optional<Fotos> findById(Integer id) {
        return fotosRepository.findById(id);
    }
    
    public Fotos save(Fotos foto) {
        return fotosRepository.save(foto);
    }
    
    public void deleteById(Integer id) {
        fotosRepository.deleteById(id);
    }
    
    public List<Fotos> findByAnimal(AnimalEncontrado animal) {
        return fotosRepository.findByAnimal(animal);
    }
}