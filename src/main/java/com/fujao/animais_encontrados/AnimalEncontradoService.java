package com.fujao.animais_encontrados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalEncontradoService {

    @Autowired
    private AnimalEncontradoRepository animalEncontradoRepository;

    public List<AnimalEncontrado> findAll() {
        return animalEncontradoRepository.findAll();
    }

    public Optional<AnimalEncontrado> findById(Integer id) {
        return animalEncontradoRepository.findById(id);
    }
    
    public AnimalEncontrado save(AnimalEncontrado animalEncontrado) {
        return animalEncontradoRepository.save(animalEncontrado);
    }
    
    public void deleteById(Integer id) {
        animalEncontradoRepository.deleteById(id);
    }
}