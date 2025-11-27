package com.fujao.comparacao;

import com.fujao.animais_encontrados.AnimalEncontrado;
import java.util.List;

public class ComparacaoResultadoDTO {
    
   
    private Integer usuarioIdDono; 
    
    
    private String nomeAnimalPerdido; 


    private List<AnimalEncontrado> animaisEncontradosSimilares;


    public ComparacaoResultadoDTO(Integer usuarioIdDono, String nomeAnimalPerdido, List<AnimalEncontrado> animaisEncontradosSimilares) {
        this.usuarioIdDono = usuarioIdDono;
        this.nomeAnimalPerdido = nomeAnimalPerdido;
        this.animaisEncontradosSimilares = animaisEncontradosSimilares;
    }

    
    public Integer getUsuarioIdDono() {
        return usuarioIdDono;
    }

    public void setUsuarioIdDono(Integer usuarioIdDono) {
        this.usuarioIdDono = usuarioIdDono;
    }

    public String getNomeAnimalPerdido() {
        return nomeAnimalPerdido;
    }

    public void setNomeAnimalPerdido(String nomeAnimalPerdido) {
        this.nomeAnimalPerdido = nomeAnimalPerdido;
    }

    public List<AnimalEncontrado> getAnimaisEncontradosSimilares() {
        return animaisEncontradosSimilares;
    }

    public void setAnimaisEncontradosSimilares(List<AnimalEncontrado> animaisEncontradosSimilares) {
        this.animaisEncontradosSimilares = animaisEncontradosSimilares;
    }
}