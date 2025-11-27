package com.fujao.animais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnimaisRepository extends JpaRepository<Animais, Integer> {
    
    List<Animais> findByPerdido(Boolean perdido);
}