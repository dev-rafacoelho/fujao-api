package com.fujao.animais_encontrados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FotosRepository extends JpaRepository<Fotos, Integer> {
    
    List<Fotos> findByAnimal(AnimalEncontrado animal);
}