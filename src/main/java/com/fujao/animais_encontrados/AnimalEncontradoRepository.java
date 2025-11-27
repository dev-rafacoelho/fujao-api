package com.fujao.animais_encontrados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnimalEncontradoRepository extends JpaRepository<AnimalEncontrado, Integer> {
    
    List<AnimalEncontrado> findByEspecieAndRaca(String especie, String raca);
}