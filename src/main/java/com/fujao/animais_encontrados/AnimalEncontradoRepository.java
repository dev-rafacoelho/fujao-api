package com.fujao.animais_encontrados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalEncontradoRepository extends JpaRepository<AnimalEncontrado, Integer> {
}