package com.fujao.animais;

import java.util.List;
import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimaisService {
    
	@Autowired
    private AnimaisRepository animaisRepository;

    public Animais save(Animais animal) {
    	return animaisRepository.save(animal);
    }

    public List<Animais> findAll() {
    	return animaisRepository.findAll();
    }

    public Optional<Animais> findById(Integer id) {
        return animaisRepository.findById(id);
    }
}